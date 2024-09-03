package com.example.exception;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.common.BadBloodTypeException;

@RestControllerAdvice
public class SampleControllerAdvise {

    @ExceptionHandler({BadBloodTypeException.class})  //  独自例外
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ErrorResponse> handleBadBloodTypeException(BadBloodTypeException e, HttpServletRequest request) {
    	ErrorResponse response = new ErrorResponse();
    	response.setStatus(HttpStatus.BAD_REQUEST.toString());
    	response.setUri(request.getRequestURL().toString());
    	response.setTitle("異常系テスト");
    	response.setErrorMessage("不正なリクエストです。");
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}
