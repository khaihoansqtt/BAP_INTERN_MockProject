package com.base.response;

import com.google.common.base.Strings;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

@Getter
@Setter
public class MetaResponse {
    private static final String PROPERTY_JSON_META_STATUS_CODE = "statusCode";
    private static final String PROPERTY_JSON_META_COUNT = "count";
    private static final String PROPERTY_JSON_META_MESSAGE = "message";
    private static final String PROPERTY_JSON_META_PAGING = "paging";

    private int statusCode;
    private int count;
    private String message;
    private PagingResponse pagingResponse = new PagingResponse();

    /**
     * Mapper meta response to json and then add it into base response json.
     * @return
     */
    public Map<String, Object> toJson(){
        Map<String, Object> jsonResult = new LinkedHashMap<>();
        if(Objects.nonNull(statusCode)){
            jsonResult.put(PROPERTY_JSON_META_STATUS_CODE, statusCode);
        }

        if(!Strings.isNullOrEmpty(message)){
            jsonResult.put(PROPERTY_JSON_META_MESSAGE, message);
        }

        jsonResult.put(PROPERTY_JSON_META_COUNT, count);

        if(count > 1){
            jsonResult.put(PROPERTY_JSON_META_PAGING, pagingResponse);
        }

        return jsonResult;
    }
}
