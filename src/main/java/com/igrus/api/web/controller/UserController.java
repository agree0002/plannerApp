package com.igrus.api.web.controller;

import com.igrus.api.domain.user.User;
import com.igrus.api.domain.user.UserService;
import com.igrus.api.global.response.ApiResponse;
import com.igrus.api.web.dto.SignupRequestDto;
import com.igrus.api.web.dto.SignupResponseDto;
import com.igrus.api.web.dto.UsernameCheckResponseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Slf4j
@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
@Validated
public class UserController {

    private final UserService userService;

    /**
     * 회원가입
     */
    @PostMapping
    public ResponseEntity<ApiResponse<SignupResponseDto>> signup(@Valid @RequestBody SignupRequestDto requestDto) {
        log.info("회원가입 요청 - username: {}", requestDto.getUsername());

        User savedUser = userService.signup(requestDto);
        SignupResponseDto responseDto = SignupResponseDto.from(savedUser);

        log.info("회원가입 성공 - userId: {}, username: {}", savedUser.getId(), savedUser.getUsername());

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(ApiResponse.created(responseDto, "회원가입이 성공적으로 완료되었습니다."));
    }

    /**
     * 사용자명 중복 확인
     */
    @GetMapping("/username-availability")
    public ResponseEntity<ApiResponse<UsernameCheckResponseDto>> checkUsernameAvailability(
            @RequestParam(value = "username", required = true)
            @NotBlank(message = "사용자명을 입력해주세요.")
            @Size(min = 3, max = 20, message = "사용자명은 3-20자 사이여야 합니다.")
            String username) {

        log.info("사용자명 중복 확인 요청 - username: {}", username);

        boolean isAvailable = userService.isUsernameAvailable(username);
        UsernameCheckResponseDto responseDto = new UsernameCheckResponseDto(username, isAvailable);

        String message = isAvailable ? "사용 가능한 사용자명입니다." : "이미 사용 중인 사용자명입니다.";

        return ResponseEntity.ok(ApiResponse.success(responseDto, message));
    }
}