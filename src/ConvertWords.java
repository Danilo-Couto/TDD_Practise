public class ConvertWords {

    // 6o caso: throw erros if StartWithNumber and EspecialChars
    public static String converterCamelCase(String original) {
        if (Character.isDigit(original.charAt(0))) {
            throw new StartWithNumberException("Inválido → não deve começar com números");
        }

        char[] originalToArray = original.toCharArray();

        for (char c: originalToArray) {
            if (!Character.isAlphabetic(c) && !Character.isDigit(c)) {
                throw new EspecialCharsException(" Inválido → caracteres especiais não são permitidos, somente letras e números");
            }
        }

        if(original.equals(original.toUpperCase())) {
            return original;
        } else {
            StringBuilder tempString = new StringBuilder();
            char nextChar = originalToArray[1];
            boolean firstOcurrence = true;

            for (int i = 0; i < originalToArray.length; i++) {
                if (i+1 < originalToArray.length) nextChar = originalToArray[i+1];

                char actualChar = originalToArray[i];
                if (Character.isUpperCase(actualChar) || Character.isDigit(actualChar)) {

                    if((Character.isUpperCase(nextChar) || Character.isDigit(actualChar)) && firstOcurrence) {
                        tempString.append(", ");
                        tempString.append(originalToArray[i]);
                        firstOcurrence = false;
                    } else if (Character.isUpperCase(nextChar) && !firstOcurrence) {
                        tempString.append(originalToArray[i]);
                    } else {
                        tempString.append(", ");
                        tempString.append(Character.toLowerCase(originalToArray[i]));
                    }

                } else {
                    tempString.append(originalToArray[i]);
                }

            }
            return tempString.toString();
        }
    }


}
