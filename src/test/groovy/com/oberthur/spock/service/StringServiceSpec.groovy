package com.oberthur.spock.service

import com.oberthur.spock.service.StringService
import spock.lang.Specification
import spock.lang.Unroll

/**
 * @author mzielinski on 18.05.15.
 */
class StringServiceSpec extends Specification {

    static def lists = [["aaa", "bbb", "aaabbb"], ["bbb", "", "bbb"], ["", "aaa", "aaa"]]

    StringService objectUnderTest = new StringService()

    @Unroll
    def "should concatenate #string1 and #string2 and return #result"() {
        expect:
        objectUnderTest.concat(val1, val2) == result

        where:
        val1  | val2  || result
        "aaa" | "bbb" || "aaabbb"
        ""    | "bbb" || "bbb"
        "aaa" | ""    || "aaa"
    }

    @Unroll
    def "pipe line version - should concatenate #string1 and #string2 and return #result"() {
        expect:
        objectUnderTest.concat(val1, val2) == result

        where:
        val1 << ["aaa", "", "aaa"]
        val2 << ["bbb", "bbb", ""]
        result << ["aaabbb", "bbb", "aaa"]
    }

    @Unroll
    def "pipe line version 2 - should concatenate #val1 and #val2 and return #result"(String val1, String val2, String result) {
        expect:
        objectUnderTest.concat(val1, val2) == result

        where:
        [val1, val2, result] << lists
    }

}
