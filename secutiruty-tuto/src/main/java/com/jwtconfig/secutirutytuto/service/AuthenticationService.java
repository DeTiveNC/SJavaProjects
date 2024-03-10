package com.jwtconfig.secutirutytuto.service;

import com.jwtconfig.secutirutytuto.dto.JWTAuthResponse;
import com.jwtconfig.secutirutytuto.dto.RefreshTokenRequest;
import com.jwtconfig.secutirutytuto.dto.SignInRequest;
import com.jwtconfig.secutirutytuto.dto.SignUpRequest;
import com.jwtconfig.secutirutytuto.entity.User;

public interface AuthenticationService {
    User signUp(SignUpRequest user);

    JWTAuthResponse signIn(SignInRequest signInRequest);

    JWTAuthResponse refreshToken(RefreshTokenRequest refreshToken);
}
