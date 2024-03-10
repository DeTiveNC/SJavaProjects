package com.jwtconfig.secutirutytuto.service.impl;

import com.jwtconfig.secutirutytuto.dto.JWTAuthResponse;
import com.jwtconfig.secutirutytuto.dto.RefreshTokenRequest;
import com.jwtconfig.secutirutytuto.dto.SignInRequest;
import com.jwtconfig.secutirutytuto.dto.SignUpRequest;
import com.jwtconfig.secutirutytuto.entity.Role;
import com.jwtconfig.secutirutytuto.entity.User;
import com.jwtconfig.secutirutytuto.repository.UserRepository;
import com.jwtconfig.secutirutytuto.service.AuthenticationService;
import com.jwtconfig.secutirutytuto.service.JWTService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager  authenticationManager;
    private final JWTService jwtService;
    @Override
    public User signUp(SignUpRequest user) {
        User newUser = new User();
        newUser.setEmail(user.getEmail());
        newUser.setPassword(passwordEncoder.encode(user.getPassword()));
        newUser.setFirstName(user.getFirstName());
        newUser.setLastName(user.getLastName());
        newUser.setRole(Role.USER);
        return userRepository.save(newUser);
    }
    @Override
    public JWTAuthResponse signIn(SignInRequest signUpRequest) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(signUpRequest.getEmail(), signUpRequest.getPassword()));
        var user = userRepository.findByEmail(signUpRequest.getEmail()).orElseThrow(() -> new IllegalArgumentException("Email not found"));
        var token = jwtService.generateToken(user);
        var refresh_token = jwtService.generateRefreshToken(new HashMap<>(), user);

        JWTAuthResponse jwtAuthResponse = new JWTAuthResponse();
        jwtAuthResponse.setToken(token);
        jwtAuthResponse.setRefreshToken(refresh_token);
        return jwtAuthResponse;
    }
    @Override
    public JWTAuthResponse refreshToken(RefreshTokenRequest refreshToken) {
        String userEmail = jwtService.extractUsername(refreshToken.getToken());
        User user = userRepository.findByEmail(userEmail).orElseThrow(() -> new IllegalArgumentException("User not found"));
        if (!jwtService.validateToken(refreshToken.getToken(), user)) {
            throw new IllegalArgumentException("Invalid refresh token");
        }
        var token = jwtService.generateToken(user);
        JWTAuthResponse jwtAuthResponse = new JWTAuthResponse();
        jwtAuthResponse.setToken(token);
        jwtAuthResponse.setRefreshToken(refreshToken.getToken());
        return jwtAuthResponse;
    }
}
