package com.example.hmrback.auth.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

// TODO: delete when we are sure that security work and pwd are decoded successfully
public class BCryptGen {
    public static void main(String[] args) {
        System.out.println(new BCryptPasswordEncoder().encode("pwd5678"));
    }
}
