package com.bankingmanagement.exception;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Slf4j
@RestControllerAdvice
public class ExceptionHandlerAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler(BankDetailsNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ExceptionResponse handleBankDetailsException(HttpServletRequest request, BankDetailsNotFoundException ex){
        log.info("Inside the Bank details not found exception handler");
        ExceptionResponse response = new ExceptionResponse();
        response.setErrorMessage(ex.getMessage());
        response.setRequestedURI(request.getRequestURI());
        log.error("Bank details not found exception", ex);
        return response;
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ExceptionResponse handleException(HttpServletRequest request, Exception ex){
        log.info("Inside the Bank details not found exception handler");
        ExceptionResponse response = new ExceptionResponse();
        response.setErrorMessage(ex.getMessage());
        response.setRequestedURI(request.getRequestURI());
        log.error("Bank details not found exception", ex);
        return response;
    }
}


