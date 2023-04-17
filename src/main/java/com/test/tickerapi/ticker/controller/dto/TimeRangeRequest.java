package com.test.tickerapi.ticker.controller.dto;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;

import java.io.Serializable;

@Schema(title = "기간 범위")
public class TimeRangeRequest implements Serializable {
    @Parameter(name = "interval", description = "기간 단위", example = "1d", required = true)
    private String interval;

    @Parameter(name = "range", description = "범위", example = "5d", required = true)
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
