package com.igrus.api.domain.user;

import com.igrus.api.domain.user.exception.DuplicateUsernameException;
import com.igrus.api.domain.user.exception.PasswordMismatchException;
import com.igrus.api.web.dto.SignupRequestDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    /**
     * 회원가입
     */
    public User signup(SignupRequestDto requestDto) {
        validateSignupRequest(requestDto);

        String encodedPassword = passwordEncoder.encode(requestDto.getPassword());

        User user = User.builder()
                .username(requestDto.getUsername())
                .password(encodedPassword)
                .build();

        User savedUser = userRepository.save(user);
        log.info("새 사용자 생성 완료 - ID: {}, Username: {}", savedUser.getId(), savedUser.getUsername());

        return savedUser;
    }

    /**
     * 회원가입 요청 검증
     */
    private void validateSignupRequest(SignupRequestDto requestDto) {
        // 중복 확인
        if (userRepository.existsByUsername(requestDto.getUsername())) {
            throw new DuplicateUsernameException(requestDto.getUsername());
        }

        // 비밀번호 확인 일치 여부
        if (!requestDto.getPassword().equals(requestDto.getConfirmPassword())) {
            throw new PasswordMismatchException();
        }
    }

    /**
     * 사용자명 사용 가능 여부 확인
     */
    @Transactional(readOnly = true)
    public boolean isUsernameAvailable(String username) {
        return !userRepository.existsByUsername(username);
    }
}