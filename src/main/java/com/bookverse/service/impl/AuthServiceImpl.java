package com.bookverse.service.impl;

import com.bookverse.dto.AuthResponseDto;
import com.bookverse.dto.RegisterRequestDto;
import com.bookverse.entity.User;
import com.bookverse.repository.UserRepository;
import com.bookverse.service.AuthService;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;

    public AuthServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
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
        user.setPassword(request.getPassword());

        user.setRole("ADMIN");

        userRepository.save(user);

        return new AuthResponseDto("User registered successfully");
    }
}