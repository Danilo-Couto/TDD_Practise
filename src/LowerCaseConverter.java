class LowerCaseConverter implements CharacterConverter {
    @Override
    public void processCharacter(char actualChar, char nextChar, StringBuilder tempString) {
        tempString.append(actualChar);
    }
}