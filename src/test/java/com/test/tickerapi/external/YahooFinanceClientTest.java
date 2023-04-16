package com.test.tickerapi.external;

import com.test.tickerapi.integration.DatabaseIntegrationTest;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

class YahooFinanceClientTest extends DatabaseIntegrationTest {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    RestTemplate restTemplate;

    @Test
    void test() {

        URI uri = UriComponentsBuilder
                .fromUriString("https://query1.finance.yahoo.com")
                .path("v8/finance/chart/" + "005930.KS")
                .queryParam("interval", "1d")
                .queryParam("range", 5d)
                .encode()
                .build()
                .toUri();

        String response = restTemplate.getForObject(uri, String.class);
        log.info("{}", response);
    }
}