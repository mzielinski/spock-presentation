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
    def "should return #result when input parameters are #string1 and #string2"() {
        expect:
        objectUnderTest.concat(string1, string2) == result

        where:
        string1 | string2 || result
        "aaa"   | "bbb"   || "aaabbb"
        ""      | "bbb"   || "bbb"
        "aaa"   | ""      || "aaa"
    }

    @Unroll
    def "pipe line version - should return #result when input parameters are #string1 and #string2"() {
        expect:
        objectUnderTest.concat(string1, string2) == result

        where:
        string1 << ["aaa", "", "aaa"]
        string2 << ["bbb", "bbb", ""]
        result << ["aaabbb", "bbb", "aaa"]
    }

    @Unroll
    def "pipe line version 2 - should return #result when input parameters are #string1 and #string2"(String string1, String string2, String result) {
        expect:
        objectUnderTest.concat(string1, string2) == result

        where:
        [string1, string2, result] << lists
    }

}
