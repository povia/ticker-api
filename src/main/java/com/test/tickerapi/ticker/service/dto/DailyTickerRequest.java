package com.test.tickerapi.ticker.service.dto;

public record DailyTickerRequest(String symbol, String interval, String range) {
}
