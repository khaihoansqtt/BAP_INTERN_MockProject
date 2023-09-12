package com.base.response;

import org.springframework.http.HttpStatus;

import java.util.Map;

@SuppressWarnings("unchecked")
public class BadRequestResponse<T> extends BaseResponse {

    public BadRequestResponse(HttpStatus status) {
        super(HttpStatus.BAD_REQUEST);
    }

    public BadRequestResponse(T body, HttpStatus status) {
        super(body, HttpStatus.BAD_REQUEST);
    }

    @Override
    public Map<String, Object> toJson() {
        Map<String, Object> jsonResult = super.toJson();
        jsonResult.put(PROPERTY_JSON_BASE_DATA, getBody());
        return jsonResult;
    }
}