public class ConvertWords {

    // refatoração completa substituindo if statements por polimorfismo
    public static String converterCamelCase(String original) {
        char[] originalToArray = original.toCharArray();

        checkFirstChar(original);
        checkForSpecialCharacters(originalToArray);

        if (original.equals(original.toUpperCase())) {
            return original;
        } else {
            StringBuilder tempString = new StringBuilder();
            convertOriginal(originalToArray, tempString);
            return tempString.toString();
        }
    }

    private static void convertOriginal(char[] originalToArray, StringBuilder tempString) {
        char nextChar = originalToArray[1];
        State firstOcurrenceState = new State(true);

        CharacterConverter converter;

        for (int i = 0; i < originalToArray.length; i++) {
            if (i + 1 < originalToArray.length) nextChar = originalToArray[i + 1];

            char actualChar = originalToArray[i];

            if (Character.isUpperCase(actualChar) || Character.isDigit(actualChar)) {
                converter = new UpperCaseOrDigitConverter(firstOcurrenceState);
            } else {
                converter = new LowerCaseConverter();
            }

            converter.processCharacter(actualChar, nextChar, tempString);
        }
    }

    private static void checkForSpecialCharacters(char[] originalToArray) {
        for (char c : originalToArray) {
            if (!Character.isLetterOrDigit(c)) {
                throw new EspecialCharsException("Inválido → caracteres especiais não são permitidos, somente letras e números");
            }
        }
    }

    private static void checkFirstChar(String original) {
        if (Character.isDigit(original.charAt(0))) {
            throw new StartWithNumberException("Inválido → não deve começar com números");
        }
    }

}
