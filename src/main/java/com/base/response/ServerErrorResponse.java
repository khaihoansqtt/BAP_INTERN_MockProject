package com.base.response;

import org.springframework.http.HttpStatus;

public class ServerErrorResponse extends BaseResponse {

    public ServerErrorResponse() {
        super(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
