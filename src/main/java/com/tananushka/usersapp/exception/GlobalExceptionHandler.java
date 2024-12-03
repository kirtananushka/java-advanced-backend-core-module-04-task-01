package com.tananushka.usersapp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler {
   @ExceptionHandler(UserNotFoundException.class)
   @ResponseStatus(HttpStatus.NOT_FOUND)
   public ErrorResponse handleUserNotFoundException(UserNotFoundException ex) {
      return new ErrorResponse(HttpStatus.NOT_FOUND.value(), ex.getMessage());
   }

   @ExceptionHandler({UsernameAlreadyExistsException.class, EmailAlreadyExistsException.class})
   @ResponseStatus(HttpStatus.CONFLICT)
   public ErrorResponse handleConflictException(RuntimeException ex) {
      return new ErrorResponse(HttpStatus.CONFLICT.value(), ex.getMessage());
   }

   @ExceptionHandler(MethodArgumentNotValidException.class)
   @ResponseStatus(HttpStatus.BAD_REQUEST)
   public ErrorResponse handleValidationException(MethodArgumentNotValidException ex) {
      List<String> errors = ex.getBindingResult()
            .getFieldErrors()
            .stream()
            .map(FieldError::getDefaultMessage)
            .toList();

      return new ErrorResponse(HttpStatus.BAD_REQUEST.value(), "Validation failed", errors);
   }
}