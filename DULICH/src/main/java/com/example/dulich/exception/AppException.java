package com.example.dulich.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AppException extends Exception{

    public AppException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }

    private ErrorCode errorCode;
}
