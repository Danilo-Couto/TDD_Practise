public class ConvertWords {

    // 4o caso: converte strings compostas em lower e upper case
    public static String converterCamelCase(String original) {
        if (original.equals(original.toUpperCase())) {
            return original;
        } else {
            StringBuilder tempString = new StringBuilder();
            char[] originalToArray = original.toCharArray();
            char nextChar = originalToArray[1];
            boolean firstOcurrence = true;

            for (int i = 0; i < originalToArray.length; i++) {
                if (i + 1 < originalToArray.length) nextChar = originalToArray[i + 1];

                char actualChar = originalToArray[i];
                if (Character.isUpperCase(actualChar)) {

                    if (Character.isUpperCase(nextChar) && firstOcurrence) {
                        tempString.append(", "); // only if is the first ocurence
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
