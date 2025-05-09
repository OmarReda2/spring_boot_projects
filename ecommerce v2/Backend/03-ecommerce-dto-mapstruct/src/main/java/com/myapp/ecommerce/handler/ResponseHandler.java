package com.myapp.ecommerce.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

public class ResponseHandler {

    public static ResponseEntity<Object> generateResponse(HttpStatus status, Object responseObj, int count){

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("status", status.value());
        map.put("count", count);
        map.put("data", responseObj);

        return new ResponseEntity<Object>(map, status);
    }
}
