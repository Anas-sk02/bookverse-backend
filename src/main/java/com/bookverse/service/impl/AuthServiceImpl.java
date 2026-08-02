package com.bookverse.service.impl;

import com.bookverse.dto.AuthResponseDto;
import com.bookverse.dto.RegisterRequestDto;
import com.bookverse.entity.User;
import com.bookverse.repository.UserRepository;
import com.bookverse.service.AuthService;
import org.springframework.stereotype.Service;


import org.springframework.security.crypto.password.PasswordEncoder;


import com.bookverse.dto.LoginRequestDto;
import com.bookverse.entity.User;

import com.bookverse.security.JwtService;


@Service
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final JwtService jwtService;

    public AuthServiceImpl(UserRepository userRepository,
                           PasswordEncoder passwordEncoder,
                           JwtService jwtService) {

        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }

    @Override
    public AuthResponseDto register(RegisterRequestDto request) {

        if (userRepository.findByEmail(request.getEmail()).isPresent()) {
            throw new RuntimeException("Email already exists");
        }

        User user = new User();

        user.setName(request.getName());
        user.setEmail(request.getEmail());

        // Abhi plain password save kar rahe hain.
        // Next step me BCrypt lagayenge.
//        user.setPassword(request.getPassword());  added Bcrypt below
        user.setPassword(passwordEncoder.encode(request.getPassword()));

        user.setRole("ROLE_USER");

        userRepository.save(user);

        return new AuthResponseDto("User registered successfully");
    }


    @Override
    public AuthResponseDto login(LoginRequestDto request) {

        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("Invalid Email"));

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new RuntimeException("Invalid Password");
        }

        String token =
                jwtService.generateToken(user.getEmail());

        return new AuthResponseDto(token);
    }
}