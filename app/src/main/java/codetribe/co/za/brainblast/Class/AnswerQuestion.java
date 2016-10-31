package codetribe.co.za.brainblast.Class;

/**
 * Created by ProJava on 10/13/2016.
 */

public class AnswerQuestion {

    private String image;
    private int score;
    private int sumOfTry;


    public AnswerQuestion() {
        super();
    }

    public AnswerQuestion(String image, int score, int sumOfTry) {
        this.image = image;
        this.score = score;
        this.sumOfTry = sumOfTry;
    }


    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getSumOfTry() {
        return sumOfTry;
    }

    public void setSumOfTry(int sumOfTry) {
        this.sumOfTry = sumOfTry;
    }
}




