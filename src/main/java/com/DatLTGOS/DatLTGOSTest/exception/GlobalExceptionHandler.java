package com.DatLTGOS.DatLTGOSTest.exception;

import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.DatLTGOS.DatLTGOSTest.DTO.APIResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(value = Exception.class)
  ResponseEntity<APIResponse> handlingServerException(Exception exception) {
    APIResponse apiResponse = new APIResponse<>();
    apiResponse.setMessage(ErrorCode.SERVER_ERROR.getMessage());
    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(apiResponse);
  }

  @ExceptionHandler(value = AppException.class)
  ResponseEntity<APIResponse> handlingAppException(AppException exception) {
    APIResponse apiResponse = new APIResponse<>();
    apiResponse.setMessage(exception.getErrorCode().getMessage());
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(apiResponse);
  }

}
