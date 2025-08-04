package com.igrus.api.domain.user.exception;

import com.igrus.api.global.exception.BusinessException;

public class DuplicateUsernameException extends BusinessException {

    public DuplicateUsernameException(String username) {
        super("이미 사용 중인 사용자명입니다: " + username, "DUPLICATE_USERNAME");
    }
}
