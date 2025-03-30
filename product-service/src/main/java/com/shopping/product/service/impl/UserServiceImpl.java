package com.shopping.product.service.impl;

import com.shopping.product.config.security.JWTUtil;
import com.shopping.product.repository.UserRepository;
import com.shopping.product.service.UserService;
import com.shopping.common.entity.user.User;
import com.shopping.exception.impl.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final JWTUtil jwtUtil;


    @Override
    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new NotFoundException("User not found"));
    }

}
