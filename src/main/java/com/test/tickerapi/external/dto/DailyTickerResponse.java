package com.test.tickerapi.external.dto;

import java.math.BigDecimal;
import java.util.List;

public record DailyTickerResponse(List<BigDecimal> open, List<BigDecimal> hi) {
}
