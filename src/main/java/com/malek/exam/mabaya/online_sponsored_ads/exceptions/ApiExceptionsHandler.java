package com.malek.exam.mabaya.online_sponsored_ads.exceptions;

import com.malek.exam.mabaya.online_sponsored_ads.models.ApiResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;

@ControllerAdvice
public class ApiExceptionsHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ApiBaseException.class)
    public ResponseEntity<Object> handleApiExceptions(ApiBaseException ex, WebRequest request) {
        ApiResponse response = new ApiResponse();
        ErrorDetails details = new ErrorDetails(ex.getMessage(), request.getDescription(false));
        response.data = details;
        response.statusCode = ex.getStatusCode();
        return new ResponseEntity<>(response, ex.getStatusCode());
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        ApiResponse response = new ApiResponse();
        ValidationError validationError = new ValidationError();
        validationError.setUri(request.getDescription(false));

        List<FieldError> fieldErrors = ex.getBindingResult().getFieldErrors();

        for (FieldError f : fieldErrors) {
            validationError.addError(f.getDefaultMessage());
        }
        response.data = validationError;
        response.statusCode = HttpStatus.BAD_REQUEST;
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }


}
