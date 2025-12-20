package com.example.demo.controller;

import com.example.demo.dto.*;
import com.example.demo.entity.UserAccount;
import com.example.demo.repository.UserAccountRepository;
import com.example.demo.security.JwtUtil;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserAccountRepository repo;
    private final JwtUtil jwtUtil;

    public AuthController(UserAccountRepository repo, JwtUtil jwtUtil) {
        this.repo = repo;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/register")
    public UserAccount register(@RequestBody RegisterRequest request) {

        UserAccount user = new UserAccount(
                request.getUsername(),
                request.getEmail(),
                request.getPassword(),   // store raw
                request.getRole()
        );

        return repo.save(user);
    }

    @PostMapping("/login")
    public AuthResponse login(@RequestBody AuthRequest request) {

        UserAccount user = repo.findByEmail(request.getEmail())
                .orElseThrow(() -> new IllegalArgumentException("Invalid credentials"));

        if (!user.getPassword().equals(request.getPassword())) {
            throw new IllegalArgumentException("Invalid credentials");
        }

        String token = jwtUtil.generateToken(
                user.getId(),
                user.getEmail(),
                user.getRole().name()
        );

        return new AuthResponse(
                token,
                user.getId(),
                user.getEmail(),
                user.getRole().name()
        );
    }
}
