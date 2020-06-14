package com.malek.exam.mabaya.online_sponsored_ads.exceptions;


import org.springframework.http.HttpStatus;

public abstract class ApiBaseException extends RuntimeException {
    public ApiBaseException(String message) {
        super(message);
    }

    public abstract HttpStatus getStatusCode();
}
