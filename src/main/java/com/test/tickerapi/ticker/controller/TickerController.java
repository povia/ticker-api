package com.test.tickerapi.ticker.controller;

import com.test.tickerapi.ticker.controller.dto.TimeRangeRequest;
import com.test.tickerapi.ticker.service.TickerService;
import com.test.tickerapi.ticker.service.dto.DailyTickerRequest;
import com.test.tickerapi.ticker.service.dto.TickerResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("ticker")
public class TickerController {

    private final TickerService tickerService;

    public TickerController(TickerService tickerService) {
        this.tickerService = tickerService;
    }

    @GetMapping("{symbol}")
    public ResponseEntity<List<TickerResponse>> ticker(@PathVariable("symbol") String symbol, @RequestParam TimeRangeRequest timeRangeRequest) {
        return ResponseEntity.ok().body(tickerService.getTicker(new DailyTickerRequest(symbol, timeRangeRequest.interval(), timeRangeRequest.range())));

    }
}
