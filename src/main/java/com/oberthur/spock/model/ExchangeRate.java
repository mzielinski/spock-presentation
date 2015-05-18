package com.oberthur.spock.model;

import java.math.BigDecimal;

/**
 * @author mzielinski on 18.05.15.
 */
public class ExchangeRate {

    private final String ccy;
    private final BigDecimal rate;

    public ExchangeRate(String ccy, BigDecimal rate) {
        this.ccy = ccy;
        this.rate = rate;
    }

    public String getCcy() {
        return ccy;
    }

    public BigDecimal getRate() {
        return rate;
    }

}
