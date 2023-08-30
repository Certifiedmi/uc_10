import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.uc_10.RegexValidator;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

class RegexValidatorTest {

    private RegexValidator regexValidator;

    @BeforeEach
    public void setUp() {
        regexValidator = new RegexValidator();
    }

    @Test
    void testTooShortInput() {
        assertFalse(regexValidator.validateInputString("A1!", 10));
    }

    @Test
    void testTooLongInput() {
        assertFalse(regexValidator.validateInputString("Apple$12345Extra", 10));
    }

    @Test
    void testMatchingInputLength() {
        assertTrue(regexValidator.validateInputString("Apple$1234", 10));
    }

    @Test
    void testMissingUppercase() {
        assertFalse(regexValidator.validateInputString("apple$1234", 10));
    }

    @Test
    void testMissingLowercase() {
        assertFalse(regexValidator.validateInputString("APPLE$1234", 10));
    }

    @Test
    void testMissingSpecialCharacter() {
        assertFalse(regexValidator.validateInputString("Apple12345", 10));
    }

    @Test
    void testMissingDigit() {
        assertFalse(regexValidator.validateInputString("Apple$word", 10));
    }

    @Test
    void testExcessWhitespace() {
        assertFalse(regexValidator.validateInputString("Apple $123", 10));  // Whitespace in the middle
        assertFalse(regexValidator.validateInputString(" Apple$123", 10));  // Leading whitespace
        assertFalse(regexValidator.validateInputString("Apple$123 ", 10));  // Trailing whitespace
        assertFalse(regexValidator.validateInputString("Apple$12\n3", 10));  // Newline character
        assertFalse(regexValidator.validateInputString("Apple$12\t3", 10));  // Tab character
    }

    @Test
    void testNullInput() {
        assertThrows(IllegalArgumentException.class, () -> regexValidator.validateInputString(null, 10));
    }

    @Test
    void testEmptyString() {
        assertFalse(regexValidator.validateInputString("", 10));
    }

    @Test
    void testDifferentMaxLength() {
        // maxLength is 5
        assertTrue(regexValidator.validateInputString("A1!aB", 5)); // Exactly 5 characters
        assertFalse(regexValidator.validateInputString("A1!aBC", 5)); // Exceeds 5 characters

        // maxLength is 8
        assertTrue(regexValidator.validateInputString("Aa$1234", 8)); // Exactly 8 characters
        assertFalse(regexValidator.validateInputString("Apple$1234", 8)); // Exceeds 8 characters

        // maxLength is 12
        assertTrue(regexValidator.validateInputString("Banana!45Xy", 12)); // Exactly 12 characters
        assertFalse(regexValidator.validateInputString("Banana!45XyZ1", 12)); // Exceeds 12 characters

        // maxLength is 20
        assertTrue(regexValidator.validateInputString("Cherry@67Aa$12345", 20)); // Exactly 20 characters
        assertFalse(regexValidator.validateInputString("Cherry@67Aa$1234567XyZ", 20)); // Exceeds 20 characters
    }
}
