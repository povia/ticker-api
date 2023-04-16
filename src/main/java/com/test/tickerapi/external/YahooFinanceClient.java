package com.test.tickerapi.external;

import com.test.tickerapi.external.dto.YahooFinanceResponse;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Component
public class YahooFinanceClient {

    private final RestTemplate restTemplate;

    public YahooFinanceClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    private static final String PREFIX = "";

    public Req<YahooFinanceResponse> getDailyTicker(String symbol) {

        URI uri = UriComponentsBuilder
                .fromUriString("https://query1.finance.yahoo.com")
                .path("v8/finance/chart/" + symbol)
                .queryParam("interval", "1d")
                .queryParam("range", 5d)
                .encode()
                .build()
                .toUri();

        ResponseEntity response = restTemplate.getForEntity(uri, ResponseEntity.class);
//        YahooFinanceResponse dto = response.getBody();

        return null;
    }



}
