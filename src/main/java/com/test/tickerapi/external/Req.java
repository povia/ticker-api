package com.test.tickerapi.external;

public class Req<T> {

    private Header header;
    private T responseBody;

    public static class Header {
        private String resCode;
    }
}