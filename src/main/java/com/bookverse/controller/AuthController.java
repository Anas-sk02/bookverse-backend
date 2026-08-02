package com.bookverse.controller;

import com.bookverse.dto.AuthResponseDto;
import com.bookverse.dto.LoginRequestDto;
import com.bookverse.dto.RegisterRequestDto;
import com.bookverse.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public AuthResponseDto register(@Valid @RequestBody RegisterRequestDto request) {

        return authService.register(request);
    }


    @PostMapping("/login")
    public AuthResponseDto login(
            @Valid @RequestBody LoginRequestDto request){

        return authService.login(request);

    }
}
