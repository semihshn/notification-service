package com.semihshn.notificationservice.domain.exception;

import lombok.Getter;

@Getter
public class SemMailException extends RuntimeException {

    private final ExceptionType exceptionType;
    private String detail;

    public SemMailException(ExceptionType exceptionType, String detail) {
        super(exceptionType.getMessage());
        this.exceptionType = exceptionType;
        this.detail = detail;
    }

    public SemMailException(ExceptionType exceptionType) {
        super(exceptionType.getMessage());
        this.exceptionType = exceptionType;
    }
}
