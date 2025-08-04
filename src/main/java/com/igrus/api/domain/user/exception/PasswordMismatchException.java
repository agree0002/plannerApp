package com.igrus.api.domain.user.exception;

import com.igrus.api.global.exception.BusinessException;

public class PasswordMismatchException extends BusinessException {

    public PasswordMismatchException() {
        super("비밀번호가 일치하지 않습니다.", "PASSWORD_MISMATCH");
    }
}
