package com.jwtconfig.secutirutytuto.controller;

import com.jwtconfig.secutirutytuto.dto.JWTAuthResponse;
import com.jwtconfig.secutirutytuto.dto.RefreshTokenRequest;
import com.jwtconfig.secutirutytuto.dto.SignInRequest;
import com.jwtconfig.secutirutytuto.dto.SignUpRequest;
import com.jwtconfig.secutirutytuto.entity.User;
import com.jwtconfig.secutirutytuto.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthenticationService authenticationService;

    @PostMapping("/sign-up")
    public ResponseEntity<User> signUp(@RequestBody SignUpRequest signUpRequest) {
        return ResponseEntity.ok(authenticationService.signUp(signUpRequest));
    }

    @PostMapping("/sign-in")
    public ResponseEntity<JWTAuthResponse> signIn(@RequestBody SignInRequest signInRequest) {
        return ResponseEntity.ok(authenticationService.signIn(signInRequest));
    }

    @PostMapping("/refresh-token")
    public ResponseEntity<JWTAuthResponse> refresh(@RequestBody RefreshTokenRequest refreshTokenRequest) {
        return ResponseEntity.ok(authenticationService.refreshToken(refreshTokenRequest));
    }
}
