package com.oberthur.spock.service;

import java.math.BigDecimal;

/**
 * @author mzielinski on 18.05.15.
 */
public interface ExternalService {
    BigDecimal retrieveExchangeRate(String ccy);
}
