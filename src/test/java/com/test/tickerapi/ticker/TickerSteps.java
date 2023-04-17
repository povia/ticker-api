package com.test.tickerapi.ticker;

import com.test.tickerapi.ticker.controller.dto.TimeRangeRequest;
import io.restassured.RestAssured;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.springframework.http.MediaType;

import java.util.HashMap;
import java.util.Map;

public class TickerSteps {
    public static ExtractableResponse<Response> 티커_조회(String symbol, TimeRangeRequest timeRangeRequest) {
        Map<String, String> params = makeRequest(timeRangeRequest);
        return RestAssured
                .given().log().all()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .queryParams(params)
                .when().get("ticker/{symbol}", symbol)
                .then().log().all().extract();
    }

    public static Map<String, String> makeRequest(TimeRangeRequest timeRangeRequest) {
        Map<String, String> params = new HashMap<>();
        params.put("interval", timeRangeRequest.interval());
        params.put("range", timeRangeRequest.range());
        return params;
    }
}
