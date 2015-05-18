package com.oberthur.spock.service

import com.oberthur.spock.model.ExchangeRate
import com.oberthur.spock.service.DatabaseService
import com.oberthur.spock.service.ExchangeRateService
import com.oberthur.spock.service.ExternalService
import spock.lang.Specification


/**
 * @author mzielinski on 18.05.15.
 */
class ExchangeRateServiceSpec extends Specification {

    static final BigDecimal EXPECTED_EXCHANGE_RATE = new BigDecimal("4.12")
    static final String PLN = "PLN"

    ExternalService externalServiceStub = Stub(ExternalService)
    DatabaseService databaseMock = Mock(DatabaseService)

    ExchangeRateService objectUnderTest = new ExchangeRateService(externalServiceStub, databaseMock)

    def "should retrieve exchange rate for given currency"() {
        given:
        externalServiceStub.retrieveExchangeRate(PLN) >> EXPECTED_EXCHANGE_RATE

        expect:
        objectUnderTest.exchangeRate(PLN) == EXPECTED_EXCHANGE_RATE
    }

    def "should throw IllegalArgumentException when currency is not set"() {
        when:
        objectUnderTest.exchangeRate(null)

        then:
        def exception = thrown(IllegalArgumentException)
        exception.message.contains("cannot be null")
    }

    def "should save exchange rate"() {
        when:
        objectUnderTest.save("PLN", BigDecimal.TEN)

        then:
        1 * databaseMock.save(_ as ExchangeRate) >> { ExchangeRate exchangeRate ->
            assert exchangeRate.ccy == "PLN"
            assert exchangeRate.rate == BigDecimal.TEN
        }
    }

}