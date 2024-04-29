public class ConvertWords {

//     1 e 2o caso: separa strings simples e compostas
    public static String converterCamelCase(String original) {

        StringBuilder tempString = new StringBuilder();
        char[] originalToArray = original.toCharArray(); // string é iterable

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
