package com.test.tickerapi.external;

import com.test.tickerapi.integration.DatabaseIntegrationTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

class YahooFinanceClientTest extends DatabaseIntegrationTest {

    @Autowired
    YahooFinanceClient yahooFinanceClient;

    @Test
    void successTest() {

    }
}