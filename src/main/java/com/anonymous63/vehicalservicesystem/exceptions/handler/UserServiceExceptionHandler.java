package com.anonymous63.vehicalservicesystem.exceptions.handler;

import com.anonymous63.vehicalservicesystem.dtos.ErrorDTO;
import com.anonymous63.vehicalservicesystem.payloads.responses.APIResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class UserServiceExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public APIResponse<?> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        List<ErrorDTO> errors = new ArrayList<>();
        ex.getBindingResult().getFieldErrors().forEach(e -> {
            ErrorDTO error = new ErrorDTO(e.getField(),e.getDefaultMessage());
            errors.add(error);
        });

        return APIResponse.builder()
                .status(false)
                .message("Validation Error")
                .errors(errors)
                .build();
    }

}