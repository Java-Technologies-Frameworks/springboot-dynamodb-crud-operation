package com.jtf.sp.dynamodb.api.payload.response;

import lombok.Data;

@Data
public class ApiResponse {

    private int status;
    private String message;
    private Object result;

    public ApiResponse(int status, String message, Object result) {
        this.status = status;
        this.message = message;
        this.result = result;
    }

}
