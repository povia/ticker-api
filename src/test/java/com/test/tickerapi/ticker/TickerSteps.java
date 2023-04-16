package com.test.tickerapi.ticker;

import io.restassured.RestAssured;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.springframework.http.MediaType;

public class TickerSteps {
    public static ExtractableResponse<Response> 티커_조회() {
        return RestAssured
                .given().log().all()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .when().get("ticker")
                .then().log().all().extract();
    }
}
