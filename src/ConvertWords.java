public class ConvertWords {

    // 3o caso: retorna a string completa se for tudo Upper Case
    public static String converterCamelCase(String original) {
        StringBuilder tempString = new StringBuilder();
        char[] originalToArray = original.toCharArray();

        if(original.equals(original.toUpperCase())) {
            return original;
        } else {
            for (char c : originalToArray) {
                if (Character.isUpperCase(c)) {
                    tempString.append(", ");
                    tempString.append(Character.toLowerCase(c));
                } else {
                    tempString.append(c);
                }
            }
            return tempString.toString();
        }
    }
}
