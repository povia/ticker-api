package com.test.tickerapi.ticker.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.test.tickerapi.ticker.service.TickerService;
import com.test.tickerapi.ticker.service.dto.TickerResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("ticker")
public class TickerController {

    private final TickerService tickerService;

    public TickerController(TickerService tickerService) {
        this.tickerService = tickerService;
    }

    @GetMapping
    public ResponseEntity<TickerResponse> ticker() throws JsonProcessingException {
        return ResponseEntity.ok().body(tickerService.getSamsungTicker());
    }
}
