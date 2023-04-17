package com.test.tickerapi.ticker.service.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import java.math.BigDecimal;

/**
 * @param timestamp 거래일자
 * @param high      최고가격
 * @param low       최저가격
 * @param open      개장가격
 * @param close     종가가격
 * @param volume    거래량
 */
@Schema(title = "티커 조회 결과")
public record TickerResponse(
        @Schema(description = "거래일자")
        Long timestamp,
        @Schema(description = "최고가격")
        BigDecimal high,
        @Schema(description = "최저가격")
        BigDecimal low,
        @Schema(description = "개장가격")
        BigDecimal open,
        @Schema(description = "종가가격")
        BigDecimal close,
        @Schema(description = "거래량")
        BigDecimal volume) {
}
