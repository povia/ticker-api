package com.test.tickerapi.ticker;

import com.test.tickerapi.acceptance.AcceptanceTest;
import com.test.tickerapi.ticker.controller.dto.TimeRangeRequest;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

class TickerAcceptanceTest extends AcceptanceTest {

    private static final String SAMSUNG_SYMBOL = "005930.KS";

    private static final String DEFAULT_INTERVAL = "1d";

    private static final String DEFAULT_RANGE = "5d";

    @Test
    @DisplayName("삼성 티커 조회 성공")
    void tickerSuccessTest() {

        // when
        ExtractableResponse<Response> response = TickerSteps.티커_조회(SAMSUNG_SYMBOL, new TimeRangeRequest(DEFAULT_INTERVAL, DEFAULT_RANGE));

        // then
        assertThat(response.statusCode()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.jsonPath().getList("timestamp").size()).isEqualTo(5);
    }

}