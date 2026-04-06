package com.webAppMongoDB.demo.exceptions;// ─────────────────────────────────────────

import com.webAppMongoDB.demo.dto.CustomErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<CustomErrorResponse> handleBusiness(CustomException ex) {

        HttpStatus status = switch (ex.getErrorCode()) {
            case "OBJECT_NOT_FOUND" -> HttpStatus.NOT_FOUND;
            case "TEST_DUPLICATE"      -> HttpStatus.CONFLICT;
            case "RECORD_INVALID_DATE",
                 "INVALID_DATE_RANGE"  -> HttpStatus.BAD_REQUEST;
            default                    -> HttpStatus.INTERNAL_SERVER_ERROR;
        };

        return ResponseEntity
                .status(status)
                .body(new CustomErrorResponse(ex.getErrorCode(), ex.getMessage()));
    }
}