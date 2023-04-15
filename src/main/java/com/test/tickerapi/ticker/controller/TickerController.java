package com.test.tickerapi.ticker.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("ticker")
public class TickerController {
    @GetMapping
    public ResponseEntity<Object> ticker() {
        return ResponseEntity.ok().body("");
    }
}
