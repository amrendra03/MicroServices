package com.hotel.hotel.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.hotel.hotel.payload.ApiResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {

   @ExceptionHandler(ResourceNotFoundException.class)
   public ResponseEntity<ApiResponse> handleResourceNotFound(ResourceNotFoundException ex) {
      String mess = ex.getMessage();
      ApiResponse res = ApiResponse.builder().message(mess).success(true).status(HttpStatus.NOT_FOUND).build();

      return new ResponseEntity<>(res, HttpStatus.NOT_FOUND);
   }

}
