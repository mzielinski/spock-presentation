package snippets.spock.parameterization

import spock.lang.Specification
import spock.lang.Title
import spock.lang.Unroll

import static snippets.ImageValidator.validate

/**
 * Spock (19 lines - empty lines not counted)
 * Spock is nicer and the output provides more information about the extensions
 * Compilation of first test is much longer
 */
@Title("Testing file extension validation method")
class ImageValidatorSpec extends Specification {

    @Unroll
    def "validate extension of #fileToValidate"() {
        when: "validator checks filename"
        def isValid = validate fileToValidate

        then: "return appropriate result"
        isValid == expectedResult

        where: "input files are"
        fileToValidate || expectedResult
        'some.jpeg'    || true
        'some.jpg'     || true
        'some.tiff'    || false
        'some.bmp'     || true
        'some.png'     || false
    }
}