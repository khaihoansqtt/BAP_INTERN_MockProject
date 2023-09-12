package com.base.response;

import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashMap;
import java.util.Map;

@Getter
@Setter
public class PagingResponse {
    private static final String PROPERTY_JSON_META_PAGE_SIZE = "size";
    private static final String PROPERTY_JSON_META_PAGE_NUMBER = "page";

    private int pageSize = 1;
    private int pageNumber = 1;

    /**
     * Mapper paging to json
     * @return
     */
    public Map<String, Object> toJson(){
        Map<String, Object> jsonResult = new LinkedHashMap<>();
        jsonResult.put(PROPERTY_JSON_META_PAGE_SIZE, pageSize);
        jsonResult.put(PROPERTY_JSON_META_PAGE_NUMBER, pageNumber);
        return null;
    }
}
