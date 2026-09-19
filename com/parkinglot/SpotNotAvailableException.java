package com.parkinglot;

public class SpotNotAvailableException extends RuntimeException{
    public SpotNotAvailableException(String message){
        super(message);
    }
}
