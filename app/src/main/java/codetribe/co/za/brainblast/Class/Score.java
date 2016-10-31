package codetribe.co.za.brainblast.Class;

import java.io.Serializable;

/**
 * Created by ProJava on 10/26/2016.
 */

public class Score implements Serializable {

    private int id;
    private int score;
    private int tryouts;
    private String section;



    public Score(int id, int score, int tryouts, String section) {
        this.id = id;
        this.score = score;
        this.tryouts = tryouts;
        this.section = section;

    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getTryouts() {
        return tryouts;
    }

    public void setTryouts(int tryouts) {
        this.tryouts = tryouts;
    }


    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }
}
