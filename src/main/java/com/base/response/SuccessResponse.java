package com.base.response;

import org.springframework.http.HttpStatus;

import java.util.Map;

public class SuccessResponse<T> extends BaseResponse<T> {

    public SuccessResponse() {
        super(HttpStatus.OK);
    }

    public SuccessResponse(T body) {
        super(body, HttpStatus.OK);
    }

    public SuccessResponse(T body, int pageNumber, int pageSize) {
        super(body, HttpStatus.OK, pageNumber, pageSize);
    }

    public SuccessResponse(T body, int count, int pageNumber, int pageSize) {
        super(body, HttpStatus.OK, count, pageNumber, pageSize);
    }

    @Override
    public Map<String, Object> toJson() {
        Map<String, Object> jsonResult = super.toJson();
        jsonResult.put(PROPERTY_JSON_BASE_DATA, getBody());
        return jsonResult;
    }
}
