package com.igrus.api.domain.user;

import com.igrus.api.web.dto.SignupRequestDto;
import com.igrus.api.web.dto.SignupResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class UserService {

    private final UserRepository userRepository;

    public User signup(SignupRequestDto requestDto) {
        User user = new User(
                requestDto.getUsername(),
                requestDto.getPassword());
        return userRepository.save(user);
    }
}
