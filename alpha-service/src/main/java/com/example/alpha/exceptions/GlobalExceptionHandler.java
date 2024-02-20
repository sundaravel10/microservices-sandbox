package com.example.alpha.exceptions;

import jakarta.ws.rs.ForbiddenException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponseException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.nio.file.AccessDeniedException;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler({ForbiddenException.class, AccessDeniedException.class})
    public ResponseEntity<Object> handleForbiddenException(Exception ex)
    {
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(new ErrorResponseException(HttpStatus.FORBIDDEN));
    }
}