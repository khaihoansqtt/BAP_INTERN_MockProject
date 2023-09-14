package com.base.spring.exception;

import com.base.dto.BaseResDto;
import com.base.dto.ErrorDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class handleExceptionController {

    @ExceptionHandler()
    protected ResponseEntity<?> handleBadRequest(NoSeminarExistedException ex) {
        ErrorDto errorDto = new ErrorDto("E12", "There are currently no seminars planned");
        return new ResponseEntity<>(BaseResDto.badRequest(errorDto), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler()
    protected ResponseEntity<Object> handleInternalServerError(RuntimeException ex) {
        ErrorDto errorDto = new ErrorDto("E0", "Internal Server Error");
        return new ResponseEntity<>(BaseResDto.badRequest(errorDto), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
