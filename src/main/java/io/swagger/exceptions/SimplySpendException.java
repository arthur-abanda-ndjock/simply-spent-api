package io.swagger.exceptions;

public class SimplySpendException extends RuntimeException {

    public SimplySpendException(Throwable e) {
        super(e);
    }

    public SimplySpendException(Throwable e, String message) {
        super(message, e);

    }

}
