package com.test.tickerapi.ticker.repository;

import com.test.tickerapi.ticker.entity.Ticker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TickerRepository extends JpaRepository<Ticker, Long> {
}
