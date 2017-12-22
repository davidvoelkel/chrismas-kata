public class Child {


    private Integer score = 0;

    public void does(Deed deed) {
        score += deed.getScore();
    }

    public Integer score() {
        return score;
    }
}
