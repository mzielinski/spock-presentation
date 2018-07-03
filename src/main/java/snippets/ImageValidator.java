package snippets;

/**
 * @author Maciej Zieliński on 27/06/18
 */
public class ImageValidator {

    /**
     * Use case:
     * Imagine we have a method that gets the filename as input and validates its extension.
     * The requirement is that only jpeg, jpg and bmp extensions pass, while tiff and png extensions are not allowed at all.
     * This method will return ‘true’ or ‘false’ based on the file extension.
     * As we can see, the code for checking each file extension should be the same, except for the extension itself.
     * Parameterization will make the code the most efficient and easy to work with.
     *
     * @param filename filename
     * @return result of validation
     */
    public static boolean validate(String filename) {
        return false;
    }
}
