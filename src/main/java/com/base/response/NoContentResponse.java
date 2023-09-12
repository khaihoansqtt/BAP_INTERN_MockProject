package com.base.response;

import org.springframework.http.HttpStatus;

public class NoContentResponse extends BaseResponse {

    public NoContentResponse() {
        super(HttpStatus.NO_CONTENT);
    }
}
