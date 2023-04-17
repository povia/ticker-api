package com.test.tickerapi.ticker.service;

import com.test.tickerapi.external.dto.yahoo.Quote;
import com.test.tickerapi.ticker.entity.Ticker;
import com.test.tickerapi.ticker.repository.TickerRepository;
import com.test.tickerapi.ticker.service.dto.TickerResponse;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@Service
public class TickerSaveService {

    private final TickerRepository tickerRepository;

    public TickerSaveService(TickerRepository tickerRepository) {
        this.tickerRepository = tickerRepository;
    }

    @Transactional
    public List<Ticker> saveTickers(List<Long> timestamp, Quote quote) {
        List<Ticker> tickers = new ArrayList<Ticker>();
        IntStream.range(0, timestamp.size()).forEach(i -> {
            Ticker ticker = new Ticker(timestamp.get(i), quote.high().get(i), quote.low().get(i), quote.open().get(i), quote.close().get(i), quote.volume().get(i));
            tickers.add(ticker);
        });

        tickerRepository.saveAll(tickers);
        return tickers;
    }
}
