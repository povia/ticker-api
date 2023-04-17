package com.test.tickerapi.ticker.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.test.tickerapi.external.YahooFinanceClient;
import com.test.tickerapi.ticker.service.dto.DailyTickerRequest;
import com.test.tickerapi.ticker.service.dto.TickerResponse;
import org.springframework.stereotype.Service;

@Service
public class TickerService {

    private static final String SAMSUNG_SYMBOL = "005930.KS";

    private static final String DEFAULT_INTERVAL = "1d";

    private static final String DEFAULT_RANGE = "5d";

    private final YahooFinanceClient yahooFinanceClient;

    public TickerService(YahooFinanceClient yahooFinanceClient) {
        this.yahooFinanceClient = yahooFinanceClient;
    }

    public TickerResponse getSamsungTicker() {
        return getTicker(new DailyTickerRequest(SAMSUNG_SYMBOL, DEFAULT_INTERVAL, DEFAULT_RANGE));
    }

    public TickerResponse getTicker(DailyTickerRequest request) {
        var result = yahooFinanceClient.getDailyTicker(request);
        return null;
    }

}
