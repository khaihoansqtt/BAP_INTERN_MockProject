package com.base.spring.exception;

public class NoSeminarExistedException extends RuntimeException{
    public NoSeminarExistedException() {
        super("There are currently no seminars planned");
    }
}
