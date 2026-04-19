package com.example.lost_found.DTO;

import lombok.Data;

@Data
public class LoginRequest {
    private String email;
    private String password;
}
