package com.funi.muyq.angular.zorroserver.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

/**
 * @Author: [muyuanqiang]
 * @CreateDate: [2018/6/12 16:55]
 */
@EnableWebMvc
@ControllerAdvice
public class GlobalControllerExceptionHandler {
    @ExceptionHandler(value = {Exception.class})
    public final ResponseEntity<ErrorDetails> serverError(HttpServletRequest request, Exception e) {
        return error(e, HttpStatus.INTERNAL_SERVER_ERROR, request.getRequestURI());
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseEntity<ErrorDetails> handleConflict(HttpServletRequest request, Exception e) {
        return error(e, HttpStatus.NOT_FOUND, request.getRequestURI());
    }

    private ResponseEntity<ErrorDetails> error(final Exception exception, final HttpStatus httpStatus, final String logRef) {
        final String message = Optional.of(exception.getMessage()).orElse(exception.getClass().getSimpleName());

        return new ResponseEntity<>(new ErrorDetails(System.currentTimeMillis(), message, logRef, httpStatus.value(), null), httpStatus);
    }

}
