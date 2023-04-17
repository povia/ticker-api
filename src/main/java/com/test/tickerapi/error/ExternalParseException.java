package com.test.tickerapi.error;

public class ExternalParseException extends RuntimeException {

    protected String code = "external_parse_error";

    public ExternalParseException(Throwable cause) {
        super(cause);
    }

    public ExternalParseException(String code) {
        super();
        this.code = code;
    }
}
