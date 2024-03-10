package com.jwtconfig.secutirutytuto.dto;

import lombok.Data;

@Data
public class SignUpRequest {
    private String email;
    private String password;
    private String firstName;
    private String lastName;
}
