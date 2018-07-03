package com.oberthur.spock.service

import spock.lang.Specification
import spock.lang.Title
import spock.lang.Unroll

/**
 * @author Maciej Zieliński on 26/06/18
 */
@Title("Testing the longest string sequence")
class LongestStringSequenceSpec extends Specification {

    @Unroll
    def "should calculate (#result) the longest string sequence in #str"() {
        expect:
        LongestStringSequence.calculateTheLongestStringSequence(str) == result

        where:
        str                                                | result
        'aaaabbbbcccchhhhiiiiiiiiiiiiibbbbbbbbbbbbccccccc' | 13
    }
}
