package com.firstSpring.controller.user.response;

import com.firstSpring.controller.user.Exception.ResponseCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class ApiResponse<T> {

    private ApiHeader header;
    private T data;
    private String msg;

    private static final int SUCCESS = 200;

    private ApiResponse(ApiHeader header,  String msg) {
        this.header = header;
        this.msg = msg;
    }

    private ApiResponse(ApiHeader header, T data, String msg) {
        this.header = header;
        this.data = data;
        this.msg = msg;
    }

    public static <T> ApiResponse<T> success(T data, String message) {
        return new ApiResponse<T>(new ApiHeader(SUCCESS, "SUCCESS"), data, message);
    }
    public static ApiResponse success(String message) {
        return new ApiResponse(new ApiHeader(SUCCESS, "SUCCESS"),  message);
    }

    public static <T> ApiResponse<T> fail(ResponseCode responseCode, T data) {
        return new ApiResponse<T>(new ApiHeader(responseCode.getHttpStatus().value(), responseCode.getMessage()), data, responseCode.getMessage());
    }
}
