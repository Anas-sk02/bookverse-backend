package com.bookverse.service;

import com.bookverse.dto.AuthResponseDto;
import com.bookverse.dto.RegisterRequestDto;

public interface AuthService {

    AuthResponseDto register(RegisterRequestDto request);

}
