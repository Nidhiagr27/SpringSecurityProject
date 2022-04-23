package com.example.project.exceptions;

public class InvalidUserException extends Exception{
    private String message;

    public InvalidUserException(String message){
        super(message);
        this.message=message;
    }
}
