package com.igrus.api.web.controller;

import com.igrus.api.domain.user.User;
import com.igrus.api.domain.user.UserService;
import com.igrus.api.global.response.ApiResponse;
import com.igrus.api.web.dto.SignupRequestDto;
import com.igrus.api.web.dto.SignupResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class SignupController {

    private final UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<ApiResponse<SignupResponseDto>> signup(@RequestBody SignupRequestDto requestDto) {
        User savedUser = userService.signup(requestDto);
        SignupResponseDto responseDto = new SignupResponseDto(savedUser.getId(), savedUser.getUsername());
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(ApiResponse.success(responseDto));
    }
}
