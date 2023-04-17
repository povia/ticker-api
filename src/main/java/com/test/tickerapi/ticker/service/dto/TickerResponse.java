package com.test.tickerapi.ticker.service.dto;

import java.math.BigDecimal;
import java.util.List;

/**
 * @param timestamp 거래일자
 * @param high      최고가격
 * @param low       최저가격
 * @param open      개장가격
 * @param close     종가가격
 * @param volume    거래량
 */
public record TickerResponse(Long timestamp, BigDecimal high, BigDecimal low, BigDecimal open,
                             BigDecimal close,
                             BigDecimal volume) {
}
