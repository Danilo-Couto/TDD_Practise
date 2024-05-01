import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class ConvertWordsTest {

    @Test
    public void testStringSimples() {
        String original = "nome";
        String expected = "nome";
        String result = ConvertWords.converterCamelCase(original);
        assertEquals(expected, result);
    }

    @Test
    public void testCamelCaseComposto() {
        String original = "nomeCompleto";
        String expected = "nome, completo";
        String result = ConvertWords.converterCamelCase(original);
        assertEquals(expected, result);
    }

    @Test
    public void testAllUpperCase() {
        String original = "CPF";
        String result = ConvertWords.converterCamelCase(original);
        assertEquals(original, result);
    }

    @Test
    public void testMixedUpperCase() {
        String original = "numeroCPFContribuinte";
        String expected = "numero, CPF, contribuinte";
        String result = ConvertWords.converterCamelCase(original);
        assertEquals(expected, result);
    }

    @Test
    public void testMixedUpperCaseAndNumbers() {
        String original = "recupera10Primeiros";
        String expected = "recupera, 10, primeiros";
        String result = ConvertWords.converterCamelCase(original);
        assertEquals(expected, result);
    }

    @Test(expected = StartWithNumberException.class)
    public void testStartWithNumber() {
        String original = "10Primeiros";
        ConvertWords.converterCamelCase(original);
    }


    @Test
    public void testEspecialChars() {
        String original = "nome#Composto";
        try {
            ConvertWords.converterCamelCase(original);
            fail();
        } catch (EspecialCharsException ignored) {
        }
    }

}