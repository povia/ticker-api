package com.test.tickerapi.external.dto.yahoo;

import java.util.List;

public record Result(List<Long> timestamp, Indicators indicators) {
}
