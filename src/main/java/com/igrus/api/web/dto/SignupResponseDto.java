package com.igrus.api.web.dto;

import com.igrus.api.domain.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SignupResponseDto {

    private Long id;
    private String username;

    public static SignupResponseDto from(User user) {
        return SignupResponseDto.builder()
                .id(user.getId())
                .username(user.getUsername())
                .build();
    }
}