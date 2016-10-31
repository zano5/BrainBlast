package codetribe.co.za.brainblast.Class;

import android.net.Uri;

import java.io.Serializable;

/**
 * Created by ProJava on 10/4/2016.
 */

public class Question implements Serializable{

    private int id;
    private String question;
    private String answer;
    private String type;
    private String url;
    private String section;



    public Question()
    {
        super();
    }

    public Question(int id, String question, String answer, String type, String url, String section) {
        this.id = id;
        this.question = question;
        this.answer = answer;
        this.type = type;
        this.url = url;
        this.section = section;

    }


    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


}
