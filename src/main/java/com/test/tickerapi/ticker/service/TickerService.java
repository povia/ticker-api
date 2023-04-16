package com.test.tickerapi.ticker.service;

import com.test.tickerapi.ticker.service.dto.TickerResponse;
import org.springframework.stereotype.Service;

@Service
public class TickerService {

    private static final String SAMSUNG_SYMBOL = "005930.KS";

    public TickerResponse getSamsungTicker() {
        return getTicker(SAMSUNG_SYMBOL);
    }
    public TickerResponse getTicker(String symbol) {
        return null;
    }
}
