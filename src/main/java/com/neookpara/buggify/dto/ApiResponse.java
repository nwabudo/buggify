package com.neookpara.buggify.dto;

import lombok.Data;

import java.util.Date;

@Data
public class ApiResponse<T> {
    private String message = "Success";
    private String timestamp = new Date().toString();
    private boolean status = true;
    private T data;

    public ApiResponse(T data) {
        this.data = data;
    }

    public ApiResponse(String message, boolean status){
        this.data = null;
        this.message = message;
        this.status = status;
    }
}
