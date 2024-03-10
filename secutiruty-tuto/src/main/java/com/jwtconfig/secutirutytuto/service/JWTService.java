package com.jwtconfig.secutirutytuto.service;

import org.springframework.security.core.userdetails.UserDetails;

import java.util.Map;

public interface JWTService {
    String generateToken(UserDetails userDetails);
    String extractUsername(String token);

    boolean validateToken(String jwt, UserDetails userDetails);

    String generateRefreshToken(Map<String, Object> extraClaims, UserDetails user);
}
