package com.funi.muyq.angular.zorroserver.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Optional;

/**
 * @Author: [muyuanqiang]
 * @CreateDate: [2018/6/12 16:55]
 */
@ControllerAdvice
@RestController
public class GlobalControllerExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(value = {Exception.class})
    public final ResponseEntity<ErrorDetails> notFoundException(final Exception e) {
        return error(e, HttpStatus.BAD_REQUEST, e.getMessage());
    }


    private ResponseEntity<ErrorDetails> error(final Exception exception, final HttpStatus httpStatus, final String logRef) {
        final String message = Optional.of(exception.getMessage()).orElse(exception.getClass().getSimpleName());

        return new ResponseEntity<>(new ErrorDetails(System.currentTimeMillis(), message, logRef), httpStatus);
    }

    @Override
    protected ResponseEntity<Object> handleNoHandlerFoundException(NoHandlerFoundException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        final String message = Optional.of(ex.getMessage()).orElse(ex.getClass().getSimpleName());
        return new ResponseEntity<>(new ErrorDetails(System.currentTimeMillis(), message, request.getContextPath()), status);
    }
}
