class UpperCaseOrDigitConverter implements CharacterConverter {
    private final State state;

    public UpperCaseOrDigitConverter(State state) {
        this.state = state;
    }

    @Override
    public void processCharacter(char actualChar, char nextChar, StringBuilder tempString) {

        if ((Character.isUpperCase(nextChar) || Character.isDigit(nextChar)) && state.isFirstOcurrence()) {
            tempString.append(", ").append(actualChar);
            state.setFirstOcurrence(false);
        } else if (Character.isUpperCase(nextChar)) {
            tempString.append(actualChar);
        } else {
            tempString.append(", ").append(Character.toLowerCase(actualChar));
        }
    }
}