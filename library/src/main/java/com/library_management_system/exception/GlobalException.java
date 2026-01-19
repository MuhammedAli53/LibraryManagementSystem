package com.library_management_system.exception;

import com.library_management_system.payload.response.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice// buna bak.
public class GlobalException {
    @ExceptionHandler(GenreException.class) // bu kısma bak
    public ResponseEntity<ApiResponse> handleGeneralException(GenreException e){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse(e.getMessage(), false));
    }
}
