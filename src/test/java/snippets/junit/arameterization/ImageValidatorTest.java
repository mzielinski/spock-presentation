package snippets.junit.arameterization;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Collection;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;
import static snippets.ImageValidator.validate;

/**
 * JUnit (30 lines - empty lines not counted)
 * JUnit is much faster
 */
@RunWith(Parameterized.class)
public class ImageValidatorTest {

    @Parameters
    public static Collection<Object[]> data() {
        return asList(new Object[][]{
                {"some.jpeg", true},
                {"some.jpg", true},
                {"some.tiff", false},
                {"some.bmp", true},
                {"some.png", false}
        });
    }

    private String file;
    private boolean isValid;

    public ImageValidatorTest(String input, boolean expected) {
        file = input;
        isValid = expected;
    }

    @Test
    public void validateFileExtension() {
        assertEquals(isValid, validate(file));
    }
}