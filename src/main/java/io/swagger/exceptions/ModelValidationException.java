package io.swagger.exceptions;

public class ModelValidationException extends RuntimeException {
    private final int code;
    private final String message;

    public int getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public ModelValidationException(int code, String message) {
        this.code = code;
        this.message = message;
    }

}
