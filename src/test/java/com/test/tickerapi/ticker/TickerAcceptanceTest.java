package com.test.tickerapi.ticker;

import com.test.tickerapi.acceptance.AcceptanceTest;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

class TickerAcceptanceTest extends AcceptanceTest {

    @Test
    @DisplayName("티커 조회 성공")
    void tickerSuccessTest() {

        // when
        ExtractableResponse<Response> response = TickerSteps.티커_조회();

        // then
        Assertions.assertThat(response.statusCode()).isEqualTo(HttpStatus.OK.value());

    }
}