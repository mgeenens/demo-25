package com.example.hmrback.auth.util;

import io.jsonwebtoken.security.Keys;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.crypto.SecretKey;
import java.util.Base64;

// TODO: delete when we are sure that security work and pwd are decoded successfully
public class BCryptGen {
    public static void main(String[] args) {
        System.out.println(new BCryptPasswordEncoder().encode("pwd5678"));

        // Generate a random HS256 secret key
        SecretKey secretKey = Keys.secretKeyFor(io.jsonwebtoken.SignatureAlgorithm.HS256);

        // Encode the key as a Base64 string (for easy storage/config)
        String base64Key = Base64.getEncoder().encodeToString(secretKey.getEncoded());

        System.out.println("Base64-encoded secret key:");
        System.out.println(base64Key);
    }
}
