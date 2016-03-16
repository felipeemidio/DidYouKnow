package com.example.android.didyouknow;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by root on 12/03/16.
 */
public class Problem {

    private String question;
    private int realAnswer;
    private List<String> answers = new ArrayList<String>();

    public Problem(String question, String answer1, String answer2, String answer3, int realAnswer){
        this.question = question;
        this.realAnswer = realAnswer;
        this.answers.add(answer1);
        this.answers.add(answer2);
        this.answers.add(answer3);
    }

    public String getQuestion() {
        return this.question;
    }

    public int getRealAnswer() {
        return realAnswer - 1;
    }

    public List<String> getAnswer() {
        return this.answers;
    }
}
