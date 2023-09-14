package com.base.spring.exception;

public class NoSeminarExistedException extends RuntimeException{
    public NoSeminarExistedException() {
        super("Now, No seminar is existed");
    }
}
