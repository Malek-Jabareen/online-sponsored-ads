package com.malek.exam.mabaya.online_sponsored_ads.exceptions;

import org.springframework.http.HttpStatus;

public class SaveToDatabaseException extends ApiBaseException {

    public SaveToDatabaseException(String message) {
        super(message);
    }

    @Override
    public HttpStatus getStatusCode() {
        return HttpStatus.NOT_FOUND;
    }

}
