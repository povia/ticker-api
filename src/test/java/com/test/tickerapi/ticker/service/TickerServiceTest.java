package com.test.tickerapi.ticker.service;

import com.test.tickerapi.integration.DatabaseIntegrationTest;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class TickerServiceTest extends DatabaseIntegrationTest {

    @Autowired
    private TickerService tickerService;

    @Test
    @DisplayName("티커 조회 성공")
    void successGetTicker() {
        tickerService.getSamsungTicker();
    }
}