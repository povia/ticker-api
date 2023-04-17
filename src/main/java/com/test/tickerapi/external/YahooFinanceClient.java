package com.test.tickerapi.external;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.test.tickerapi.error.ExternalParseException;
import com.test.tickerapi.ticker.service.dto.DailyTickerRequest;
import com.test.tickerapi.external.dto.YahooFinanceResponse;
import com.test.tickerapi.external.dto.yahoo.Quote;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Collection;
import java.util.List;

@Component
public class YahooFinanceClient {

    private static final String baseUrl = "https://query1.finance.yahoo.com";

    private static final String chartUrl = "v8/finance/chart/";

    private final RestTemplate restTemplate;

    private final ObjectMapper objectMapper;

    public YahooFinanceClient(RestTemplate restTemplate, ObjectMapper objectMapper) {
        this.restTemplate = restTemplate;
        this.objectMapper = objectMapper;
    }

    private static final String PREFIX = "";

    public YahooFinanceResponse getDailyTicker(DailyTickerRequest request) {

        UriComponents uriComponents = UriComponentsBuilder
                .fromUriString(baseUrl)
                .path(chartUrl + request.symbol())
                .queryParam("interval", request.interval())
                .queryParam("range", request.range())
                .encode()
                .build();

        String response = restTemplate.getForObject(uriComponents.toUri(), String.class);
        YahooFinanceResponse result = null;
        try {
            result = objectMapper.readValue(response, YahooFinanceResponse.class);
        } catch (JsonProcessingException e) {
            throw new ExternalParseException(e);
        }
        return result;
    }


}
