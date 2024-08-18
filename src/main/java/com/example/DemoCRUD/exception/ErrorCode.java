package com.example.DemoCRUD.exception;

public enum ErrorCode {
    USER_EXISTS(1001, "User already exists"),
    UNCADEGROZIED_EXCEPTION(9999, "Uncategorized exception"),
    USERNAME_INVALID(1002, "Username must be at least 3 characters"),
    PASSWORD_INVALID(1003, "Password must be at least 8 characters"),
    INVALIDKEY(1004, "Invalid key"),
    USER_NOT_FOUND(1005, "User not found"),
    UNAUTHENTICATED(1006, "Unauthenticated"),
    ;

    private int code;
    private String message;

    ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
