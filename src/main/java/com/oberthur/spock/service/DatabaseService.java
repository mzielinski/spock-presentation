package com.oberthur.spock.service;

import com.oberthur.spock.model.ExchangeRate;

/**
 * @author mzielinski on 18.05.15.
 */
public interface DatabaseService {
    void save(ExchangeRate exchangeRate);
}
