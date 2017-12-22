public enum Deed {
    DONATE_A_KIDNEY(100), HELP_OLD_PERSON_CROSS_THE_STREET(1);

    private Integer score;


    Deed(int score) {
        this.score = score;
    }

    public Integer getScore() {
        return score;
    }
}
