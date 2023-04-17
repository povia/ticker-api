package com.test.tickerapi.ticker.controller.dto;

import java.io.Serializable;

public class TimeRangeRequest implements Serializable {
    private String interval;
    private String range;

    public TimeRangeRequest(String interval, String range) {
        this.interval = interval;
        this.range = range;
    }

    public String interval() {
        return interval;
    }

    public String range() {
        return range;
    }
}
