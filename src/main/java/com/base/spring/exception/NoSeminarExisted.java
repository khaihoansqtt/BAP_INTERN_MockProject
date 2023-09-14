package com.base.spring.exception;

public class NoSeminarExisted extends RuntimeException{
    public NoSeminarExisted() {
        super("Now, No seminar is existed");
    }
}
