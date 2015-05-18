package com.oberthur.spock.service;

import com.oberthur.spock.model.ExchangeRate;

import java.math.BigDecimal;

/**
 * @author mzielinski on 18.05.15.
 */
public class ExchangeRateService {

    private final ExternalService externalService;
    private final DatabaseService databaseService;

    public ExchangeRateService(ExternalService externalService, DatabaseService databaseService) {
        this.externalService = externalService;
        this.databaseService = databaseService;
    }

    public BigDecimal exchangeRate(String ccy) {
        if (ccy == null || "".equals(ccy)) {
            throw new IllegalArgumentException("ccy cannot be null");
        }
        return externalService.retrieveExchangeRate(ccy);
    }

    public void save(String ccy, BigDecimal rate) {
        databaseService.save(new ExchangeRate(ccy, rate));
    }

}
