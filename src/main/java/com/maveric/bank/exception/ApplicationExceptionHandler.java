package com.maveric.bank.exception;
import com.maveric.bank.model.Account;

import com.maveric.bank.model.ApplicationError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


    @ControllerAdvice
    public class ApplicationExceptionHandler {

        @ExceptionHandler({AccountNotFoundException.class})
        public ResponseEntity<ApplicationError> handleException(AccountNotFoundException e) {
            ApplicationError error = new ApplicationError(HttpStatus.NOT_FOUND, e.getMessage());
            return new ResponseEntity<>(error, error.getHttpStatus());
        }

        @ExceptionHandler({MethodArgumentNotValidException.class})
        public ResponseEntity<ApplicationError> handleInvalidRequestException(MethodArgumentNotValidException e) {
            ApplicationError error = new ApplicationError(HttpStatus.BAD_REQUEST, e.getBindingResult().getFieldError().getField() + " " + e.getBindingResult().getFieldError().getDefaultMessage());
            return new ResponseEntity<>(error, error.getHttpStatus());
        }

        @ExceptionHandler({Exception.class})
        public ResponseEntity<ApplicationError> handleAllOtherException(Exception e) {
            ApplicationError error = new ApplicationError(HttpStatus.INTERNAL_SERVER_ERROR, e.getLocalizedMessage());
            return new ResponseEntity<>(error, error.getHttpStatus());
        }

    }


