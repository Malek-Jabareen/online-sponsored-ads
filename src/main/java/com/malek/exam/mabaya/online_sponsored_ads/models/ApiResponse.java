package com.malek.exam.mabaya.online_sponsored_ads.models;

import org.springframework.http.HttpStatus;

public class ApiResponse {

    public HttpStatus statusCode;
    public String message;
    public String exception;
    public Object data;

    public ApiResponse() {
        this.statusCode = HttpStatus.OK;
        this.message = "";
        this.exception = "";
        this.data = null;
    }
}
