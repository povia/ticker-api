package com.test.tickerapi.ticker.service;

import com.test.tickerapi.external.YahooFinanceClient;
import com.test.tickerapi.external.dto.yahoo.Quote;
import com.test.tickerapi.ticker.entity.Ticker;
import com.test.tickerapi.ticker.service.dto.DailyTickerRequest;
import com.test.tickerapi.ticker.service.dto.TickerResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TickerService {

    private final YahooFinanceClient yahooFinanceClient;

    private final TickerSaveService tickerSaveService;

    public TickerService(YahooFinanceClient yahooFinanceClient, TickerSaveService tickerSaveService) {
        this.yahooFinanceClient = yahooFinanceClient;
        this.tickerSaveService = tickerSaveService;
    }

    public List<TickerResponse> getTicker(DailyTickerRequest request) {
        var result = yahooFinanceClient.getDailyTicker(request);

        List<Long> timestamp = result.chart().result().stream().findFirst().get().timestamp();
        Quote quote = result.chart().result().stream().findFirst().get().indicators().quote().stream().findFirst().get();

        List<Ticker> tickers = tickerSaveService.saveTickers(timestamp, quote);
        return tickers.stream().map(t -> new TickerResponse(t.getTimestamp(), t.getHigh(), t.getLow(), t.getOpen(), t.getClose(), t.getVolume())).toList();
    }

}
