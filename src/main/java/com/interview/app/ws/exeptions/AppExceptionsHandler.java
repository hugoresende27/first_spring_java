package com.interview.app.ws.exeptions;

import com.interview.app.ws.model.response.ErrorMessage;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@RestControllerAdvice
public class AppExceptionsHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<Object> handleAnyException(Exception ex, WebRequest request){

        String errorMessageDescription = ex.getLocalizedMessage();

        if (errorMessageDescription == null) errorMessageDescription = ex.toString();
        ErrorMessage errorMessage = new ErrorMessage(new Date(),ex.getLocalizedMessage());
        return new ResponseEntity<>(
                errorMessage, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value = {NullPointerException.class, UserServiceException.class}) //handle null pointer exception
    public ResponseEntity<Object> handleNullPointerException(NullPointerException ex, WebRequest request){

        String errorMessageDescription = ex.getLocalizedMessage();

        if (errorMessageDescription == null) errorMessageDescription = ex.toString();

        ErrorMessage errorMessage = new ErrorMessage(new Date(),ex.getLocalizedMessage());

        return new ResponseEntity<>(
                errorMessage, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    /*  above used in brackets {NullPointerException.class, UserServiceException.class}
    @ExceptionHandler(value = {UserServiceException.class}) //handle null pointer exception
    public ResponseEntity<Object> handleUserServiceException(UserServiceException ex, WebRequest request){

        String errorMessageDescription = ex.getLocalizedMessage();

        if (errorMessageDescription == null) errorMessageDescription = ex.toString();
        ErrorMessage errorMessage = new ErrorMessage(new Date(),ex.getLocalizedMessage());

        return new ResponseEntity<>(
                errorMessage, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
    */

}
