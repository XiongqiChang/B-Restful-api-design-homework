package com.thoughtworks.capability.gtb.restfulapidesign.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @Author: xqc
 * @Date: 2020/10/20 - 10 - 20 - 16:27
 * @Description: com.thoughtworks.capability.gtb.restfulapidesign.exception
 * @version: 1.0
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<Error> handle(StudentNotExistException e){
        return  ResponseEntity.badRequest().body(e.getError());
    }

    @ExceptionHandler
    public ResponseEntity<Error> handle(StudentHasExistException e){
        return  ResponseEntity.badRequest().body(e.getError());
    }

    @ExceptionHandler
    public ResponseEntity<Error> handle(GroupNotExistException e){
        return  ResponseEntity.badRequest().body(e.getError());
    }
}
