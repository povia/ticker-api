package com.test.tickerapi.external.dto.yahoo;

import java.math.BigDecimal;
import java.util.List;

public record Quote(List<BigDecimal> close, List<BigDecimal> volume, List<BigDecimal> high, List<BigDecimal> open, List<BigDecimal> low) {
}
