package com.maveric.bank.model;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@RequiredArgsConstructor

public class ApplicationError {
    private final HttpStatus httpStatus;
    private final String message;
}

