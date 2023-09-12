package com.base.response;

import com.base.utils.ObjectUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

public abstract class BaseResponse<T> extends ResponseEntity<T> {
    private static final String PROPERTY_JSON_BASE_META = "meta";
    protected static final String PROPERTY_JSON_BASE_DATA = "data";

    private HttpStatus httpStatus = HttpStatus.OK;
    private MetaResponse metaResponse = new MetaResponse();

    public BaseResponse(HttpStatus status) {
        super(status);
        initMetaResponse();
    }

    public BaseResponse(T body, HttpStatus status) {
        super(body, status);
        this.httpStatus = ObjectUtils.isNullOrEmpty(body) ? HttpStatus.NO_CONTENT : status;
        initMetaResponse();
    }

    public BaseResponse(T body, HttpStatus status, int pageNumber, int pageSize) {
        super(body, status);
        this.httpStatus = ObjectUtils.isNullOrEmpty(body) ? HttpStatus.NO_CONTENT : status;
        initMetaResponse(pageNumber, pageSize);
    }

    public BaseResponse(T body, HttpStatus status, int count, int pageNumber, int pageSize) {
        super(body, status);
        this.httpStatus = ObjectUtils.isNullOrEmpty(body) ? HttpStatus.NO_CONTENT : status;
        initMetaResponse(count, pageNumber, pageSize);

    }

    private void initMetaResponse(){
        metaResponse.setStatusCode(this.httpStatus == HttpStatus.NO_CONTENT ? this.httpStatus.value() : getStatusCodeValue());
        metaResponse.setMessage(this.httpStatus == HttpStatus.NO_CONTENT ?
                this.httpStatus.getReasonPhrase() : getStatusCode().getReasonPhrase());
        if (ObjectUtils.isNotNull(getBody())) {
            metaResponse.setCount(1);
        }
        initPaging();
    }

    private void initMetaResponse(int pageNumber, int pageSize){
        initMetaResponse();
        metaResponse.getPagingResponse().setPageNumber(pageNumber);
        metaResponse.getPagingResponse().setPageSize(pageSize);
    }

    private void initMetaResponse(int count, int pageNumber, int pageSize){
        initMetaResponse(pageNumber, pageSize);
        metaResponse.setCount(count);
    }

    private void initPaging(){
        if(getBody() instanceof Collection){
            metaResponse.setCount(((Collection) getBody()).size());
            metaResponse.getPagingResponse().setPageNumber(1);
            metaResponse.getPagingResponse().setPageSize(((Collection) getBody()).size());
        }
    }

    /**
     * Mapper meta response to json and then add it into base response json.
     * @return
     */
    public Map<String, Object> toJson(){
        Map<String, Object> jsonResult = new LinkedHashMap<>();
        jsonResult.put(PROPERTY_JSON_BASE_META, metaResponse.toJson());
        return jsonResult;
    }
}
