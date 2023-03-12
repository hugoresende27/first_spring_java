package com.interview.app.ws.exeptions;

public class UserServiceException extends RuntimeException{

    private static final long serialVersionUID = 1234576141;
    public UserServiceException(String message)
    {
        super(message);
    }
}
