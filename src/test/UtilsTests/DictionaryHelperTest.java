package test.UtilsTests;

import org.junit.jupiter.api.Test;
import static main.Utils.DictionaryHelper.validateInput;
import static org.junit.jupiter.api.Assertions.*;

class DictionaryHelperTest {

    @Test
    void validateInputHappyCaseTest() {
        String[] str = {"add", "foo", "bar"};

        assertFalse(validateInput(str, 3));
    }

    @Test
    void validateInputInvalidNumberOfArgumentTest() {
        String[] str= {"add", "foo"};

        assertTrue(validateInput(str, 3));
    }

    @Test
    void validateInputNullInputTest() {
        String[] str = {"add", "null", "bar"};

        assertTrue(validateInput(str, 3));
    }
}