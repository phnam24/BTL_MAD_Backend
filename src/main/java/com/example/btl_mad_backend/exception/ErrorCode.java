package com.example.btl_mad_backend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

import lombok.Getter;

@Getter
public enum ErrorCode {
    UNCATEGORIZED_EXCEPTION("Lỗi không xác định", HttpStatus.INTERNAL_SERVER_ERROR),
    USER_EXISTED("Email đã được sử dụng", HttpStatus.CONFLICT),
    INVALID_EMAIL("Email sai định dạng", HttpStatus.BAD_REQUEST),
    INVALID_PASSWORD("Mật khẩu phải dài hơn 8 ký tự", HttpStatus.BAD_REQUEST),
    USER_NOT_EXISTED("Tài khoản không tồn tại", HttpStatus.NOT_FOUND),
    UNAUTHENTICATED("Sai tài khoản hoặc mật khẩu", HttpStatus.UNAUTHORIZED),
    UNAUTHORIZED("Không có quyền truy cập", HttpStatus.FORBIDDEN),
    MISSING_GRADE("Chưa chọn khối học", HttpStatus.BAD_REQUEST),
    MISSING_POSITION("Chưa chọn chức vụ", HttpStatus.BAD_REQUEST),
    WRONG_PASSWORD("Sai mật khẩu", HttpStatus.BAD_REQUEST),
    ;

    ErrorCode(String message, HttpStatusCode statusCode) {
        this.message = message;
        this.statusCode = statusCode;
    }

    private final String message;
    private final HttpStatusCode statusCode;
}