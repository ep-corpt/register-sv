package com.ep.registersv.common;

import com.ep.registersv.model.RegisterResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Slf4j
@RestController
@ControllerAdvice
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<RegisterResponse> exception(Exception e) {
        log.error("Exception occurred ", e);
        return ResponseEntity.ok().body(new RegisterResponse("00001", "Internal error, please try again"));
    }

    @ExceptionHandler(RegisterException.class)
    public ResponseEntity<RegisterResponse> RegisterException(RegisterException e) {
        return ResponseEntity.ok().body(new RegisterResponse(e.getStatusCode(), e.getMessage()));
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        ObjectError objectError = ex.getBindingResult().getAllErrors().get(0);
        return ResponseEntity.ok().body(new RegisterResponse("00001", objectError.getDefaultMessage()));
    }

}