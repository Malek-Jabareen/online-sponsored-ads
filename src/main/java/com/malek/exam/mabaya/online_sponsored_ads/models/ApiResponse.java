package com.malek.exam.mabaya.online_sponsored_ads.models;

import org.springframework.http.HttpStatus;

public class ApiResponse<T> {

    public HttpStatus statusCode;
    public String message;
    public String exception;
    public T data;

    public ApiResponse() {
        this.statusCode = HttpStatus.OK;
        this.message = "";
        this.exception = "";
        this.data = null;
    }
}
