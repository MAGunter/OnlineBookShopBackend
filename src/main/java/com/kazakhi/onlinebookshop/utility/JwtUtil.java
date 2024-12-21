package com.kazakhi.onlinebookshop.utility;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtUtil {
    private static final String SECRET = "your-secret-key";
    private static final long EXPIRATION_TIME = 86400000; // 24 часа

    public String generateToken(String username) {
        return JWT.create()
                .withSubject(username)
                .withExpiresAt(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .sign(Algorithm.HMAC512(SECRET));
    }

    public String validateTokenAndRetrieveSubject(String token) {
        return JWT.require(Algorithm.HMAC512(SECRET))
                .build()
                .verify(token)
                .getSubject();
    }
}

