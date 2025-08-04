package com.igrus.api.web.dto;

import com.igrus.api.web.dto.validation.PasswordMatches;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@PasswordMatches
public class SignupRequestDto {

    @NotBlank(message = "사용자명은 필수입니다.")
    @Size(min = 3, max = 20, message = "사용자명은 3-20자 사이여야 합니다.")
    private String username;

    @NotBlank(message = "비밀번호는 필수입니다.")
    @Size(min = 4, max = 20, message = "비밀번호는 4-20자 사이여야 합니다.")
    private String password;

    @NotBlank(message = "비밀번호 확인은 필수입니다.")
    private String confirmPassword;

    /**
     * 테스트용 정적 팩토리 메서드
     */
    public static SignupRequestDto of(String username, String password, String confirmPassword) {
        return SignupRequestDto.builder()
                .username(username)
                .password(password)
                .confirmPassword(confirmPassword)
                .build();
    }
}