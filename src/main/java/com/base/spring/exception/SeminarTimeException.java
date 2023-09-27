package com.base.spring.exception;

public class SeminarTimeException extends RuntimeException{
    public SeminarTimeException() {
        super("Time of seminar is invalid");
    }
}
