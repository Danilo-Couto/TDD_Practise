class State {
    private boolean firstOcurrence;

    public State(boolean firstOcurrence) {
        this.firstOcurrence = firstOcurrence;
    }

    public boolean isFirstOcurrence() {
        return firstOcurrence;
    }

    public void setFirstOcurrence(boolean firstOcurrence) {
        this.firstOcurrence = firstOcurrence;
    }
}