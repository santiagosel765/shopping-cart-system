package com.shopping.auth.service;

import com.shopping.common.dto.AuthResponse;
import com.shopping.common.dto.RegisterRequest;
import com.shopping.common.entity.user.AuthUserRole;
import com.shopping.common.entity.user.User;

public interface UserService {

    User getUserByUsername(String username);

    User getUserByEmail(String email);

    void changePassword(Long userId, String newPassword, String confirmPassword);

    User getAuthUser(String username);

    AuthUserRole getUserRole(Long userId);

    AuthResponse registerUser(RegisterRequest request);

    AuthResponse authenticate(String username, String password);

    AuthResponse recoverPassword(String newPassword, String confirmPassword, String userToken);
}
