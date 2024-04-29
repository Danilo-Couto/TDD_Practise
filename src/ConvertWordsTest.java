import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

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

}