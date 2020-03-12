package com.yezan.otraining.security;

public class JWTResponse {
    private final String token;

    public JWTResponse(String token) {
        this.token = token;
    }

    public String getToken() {
        return this.token;
    }
}
