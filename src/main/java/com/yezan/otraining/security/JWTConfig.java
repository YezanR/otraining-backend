package com.yezan.otraining.security;

import org.springframework.beans.factory.annotation.Value;

public class JWTConfig {

    @Value("security.jwt.secret")
    private String secret;

    @Value("security.jwt.expirationTime")
    private long expirationTime;

    @Value("security.jwt.tokenPrefix")
    private String tokenPrefix;

    @Value("security.jwt.headerString")
    private String headerString;

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public long getExpirationTime() {
        return expirationTime;
    }

    public void setExpirationTime(long expirationTime) {
        this.expirationTime = expirationTime;
    }

    public String getTokenPrefix() {
        return tokenPrefix;
    }

    public void setTokenPrefix(String tokenPrefix) {
        this.tokenPrefix = tokenPrefix;
    }

    public String getHeaderString() {
        return headerString;
    }

    public void setHeaderString(String headerString) {
        this.headerString = headerString;
    }
}