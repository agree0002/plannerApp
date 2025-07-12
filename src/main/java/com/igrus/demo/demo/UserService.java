package com.igrus.demo.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new IllegalArgumentException("사용자를 찾을 수 없습니다."));
    }

    public boolean authenticateUser(String email, String password) {
        User user = findUserByEmail(email);
        return user.getPassword().equals(password); // 실제로는 암호화된 비밀번호를 검증해야 함
    }

    public Integer getUserId(String email) {
        User user = findUserByEmail(email);
        return user.getUser_id();
    }
}