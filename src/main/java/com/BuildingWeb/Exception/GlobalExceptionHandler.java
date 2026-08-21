package com.BuildingWeb.Exception;

import com.BuildingWeb.Utils.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    @ExceptionHandler(value = AppException.class)
    public ResponseEntity<ApiResponse<Object>> handleException(AppException exception) {
        ErrorCode errorCode = exception.getErrorCode();
        log.warn("AppException: [Code: {}, Message: {}]", errorCode.getCode(), errorCode.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(ApiResponse.error(errorCode.getCode(), errorCode.getMessage()));
    }
}
