package com.krafton.exam.common.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

import static org.springframework.http.HttpStatus.*;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {

    SUCCESS(OK, 0, "Success"), ERROR(INTERNAL_SERVER_ERROR, -1, "Internal Server Error"),

    NOT_EXISTS_ACCOUNT(BAD_REQUEST, 1000, "존재하지 않는 사용자입니다.");


    private final HttpStatus status;
    private final Integer code;
    private final String message;
}
