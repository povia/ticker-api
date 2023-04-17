package com.test.tickerapi.ticker.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table
public class Ticker {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal high;

    private BigDecimal low;

    private BigDecimal open;

    private BigDecimal close;

    private BigDecimal volume;

    private Long timestamp;

    public Ticker() {
    }

    public Ticker(Long timestamp, BigDecimal high, BigDecimal low, BigDecimal open, BigDecimal close, BigDecimal volume) {
        this.high = high;
        this.low = low;
        this.open = open;
        this.close = close;
        this.volume = volume;
        this.timestamp = timestamp;
    }

    public Long getId() {
        return id;
    }

    public BigDecimal getHigh() {
        return high;
    }

    public BigDecimal getLow() {
        return low;
    }

    public BigDecimal getOpen() {
        return open;
    }

    public BigDecimal getClose() {
        return close;
    }

    public BigDecimal getVolume() {
        return volume;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setHigh(BigDecimal high) {
        this.high = high;
    }

    public void setLow(BigDecimal low) {
        this.low = low;
    }

    public void setOpen(BigDecimal open) {
        this.open = open;
    }

    public void setClose(BigDecimal close) {
        this.close = close;
    }

    public void setVolume(BigDecimal volume) {
        this.volume = volume;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

}
