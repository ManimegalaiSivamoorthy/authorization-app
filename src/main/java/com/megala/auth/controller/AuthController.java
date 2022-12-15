package com.megala.auth.controller;

import com.megala.auth.model.AuthRequest;
import com.megala.auth.model.AuthResponse;
import com.megala.auth.model.Role;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;

import static com.megala.auth.constant.AppConstant.*;

@RestController
@RequestMapping("/auth_management/v1")
public class AuthController {
    @PostMapping("/validate")
    AuthResponse validateUser(@RequestBody AuthRequest request) {
        switch (request.getUserId()) {
            case USER_NAME_VEL:
                return new AuthResponse(request.getUserId(), Arrays.asList(Role.SUPPORT, Role.WRITE, Role.ADMIN));
            case USER_NAME_MEGALA:
                return new AuthResponse(request.getUserId(), Arrays.asList(Role.SUPPORT));
            case USER_NAME_MANIMEGALAI:
                return new AuthResponse(request.getUserId(), Arrays.asList(Role.ADMIN));
            case USER_NAME_VETRI:
                return new AuthResponse(request.getUserId(), Arrays.asList(Role.READ_ONLY));
            case USER_NAME_VETRISELVAN:
                return new AuthResponse(request.getUserId(), Arrays.asList(Role.WRITE, Role.ADMIN));
            default:
                return new AuthResponse(request.getUserId(), new ArrayList<>());
        }
    }
}
