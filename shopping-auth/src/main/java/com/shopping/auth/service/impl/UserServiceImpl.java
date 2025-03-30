package com.shopping.auth.service.impl;

import com.shopping.auth.repository.AuthUserRoleRepository;
import com.shopping.auth.repository.RoleRepository;
import com.shopping.auth.repository.UserRepository;
import com.shopping.auth.repository.UserStatusRepository;
import com.shopping.auth.service.UserService;
import com.shopping.common.dto.AuthResponse;
import com.shopping.common.dto.RegisterRequest;
import com.shopping.common.entity.user.Role;
import com.shopping.common.entity.user.AuthUserRole;
import com.shopping.common.entity.user.User;
import com.shopping.common.entity.user.UserStatus;
import com.shopping.auth.config.security.JWTUtil;
import com.shopping.exception.impl.BadRequestException;
import com.shopping.exception.impl.NotFoundException;
import io.jsonwebtoken.Claims;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.shopping.common.enums.DefaultRole;


@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final AuthUserRoleRepository authUserRoleRepository;
    private final RoleRepository roleRepository ;
    private final UserStatusRepository userStatusRepository ;
    private final JWTUtil jwtUtil;

    @Override
    public User getAuthUser(String username) {
        return userRepository.findByUsernameAndStatus(username, new UserStatus(1))
                .orElseThrow(() -> new NotFoundException("User not found or inactive"));
    }

    @Override
    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new NotFoundException("User not found"));
    }

    @Override
    public User getUserByEmail(String email) {
        return userRepository.findByEmailAndStatus(email, new UserStatus(1))
                .orElseThrow(() -> new NotFoundException("User with provided email not found or inactive"));
    }

    @Override
    @Transactional
    public void changePassword(Long userId, String newPassword, String confirmPassword) {
        if (!newPassword.equals(confirmPassword)) {
            throw new BadRequestException("New password and confirmation do not match");
        }

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new NotFoundException("User not found"));

        user.setPassword(new BCryptPasswordEncoder().encode(newPassword));
        user.setStatus(new UserStatus(1));
        userRepository.save(user);
    }

    @Override
    public AuthUserRole getUserRole(Long userId) {
        return authUserRoleRepository.findByUserId(userId)
                .orElseThrow(() -> new NotFoundException("User role not found"));
    }

    @Override
    public AuthResponse registerUser(RegisterRequest request) {
        if (userRepository.findByUsername(request.getUsername()).isPresent()) {
            throw new BadRequestException("Username already exists");
        }

        UserStatus activeStatus = userStatusRepository.findById(1)
                .orElseThrow(() -> new RuntimeException("Estado de usuario no encontrado"));

        User user = User.builder()
                .username(request.getUsername())
                .email(request.getEmail())
                .password(new BCryptPasswordEncoder().encode(request.getPassword()))
                .fullName(request.getFullName())
                .status(activeStatus)
                .build();

        User saved = userRepository.save(user);

        Role defaultRole = roleRepository.findById(DefaultRole.USER.getId())
                .orElseThrow(() -> new RuntimeException("Rol por defecto no encontrado"));

        AuthUserRole userRole = AuthUserRole.builder()
                .user(saved)
                .role(defaultRole)
                .status(1)
                .build();

        authUserRoleRepository.save(userRole);

        String token = jwtUtil.generateToken(saved);

        return AuthResponse.builder()
                .token(token)
                .username(saved.getUsername())
                .email(saved.getEmail())
                .role(defaultRole.getName())
                .build();
    }

    @Override
    public AuthResponse authenticate(String username, String password) {
        User user = getAuthUser(username);

        if (!new BCryptPasswordEncoder().matches(password, user.getPassword())) {
            throw new BadRequestException("Invalid credentials");
        }

        String token = jwtUtil.generateToken(user);
        AuthUserRole role = getUserRole(user.getId());

        return AuthResponse.builder()
                .token(token)
                .username(user.getUsername())
                .email(user.getEmail())
                .role(role.getRole().getName())
                .build();
    }

    @Override
    public AuthResponse recoverPassword(String newPassword, String confirmPassword, String userToken) {
        Claims claims = jwtUtil.getClaims(userToken);
        String username = claims.getSubject();

        User user = getUserByUsername(username);
        changePassword(user.getId(), newPassword, confirmPassword);

        String token = jwtUtil.generateToken(user);
        AuthUserRole role = getUserRole(user.getId());

        return AuthResponse.builder()
                .token(token)
                .username(user.getUsername())
                .email(user.getEmail())
                .role(role.getRole().getName())
                .build();
    }
}
