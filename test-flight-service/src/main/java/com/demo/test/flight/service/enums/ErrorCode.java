package com.demo.test.flight.service.enums;

public enum ErrorCode {

    INTERNAL_SERVER_ERROR(1000L, "Internal Server Error.");

    private Long code;
    private String message;

    ErrorCode(Long code, String message){
        this.code = code;
        this.message = message;
    }

    public Long getCode() {
        return code;
    }

}