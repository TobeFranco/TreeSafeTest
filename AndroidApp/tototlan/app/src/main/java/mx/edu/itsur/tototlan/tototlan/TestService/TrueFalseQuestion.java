/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.itsur.tototlan.tototlan.TestService;

import java.util.List;

/**
 *
 * @author tobefranco
 */
public class TrueFalseQuestion extends ServiceQuestion{
    private List<Integer> answer;
    private int correct;

    public List<Integer> getAnswer() {
        return answer;
    }

    public void setAnswer(List<Integer> answer) {
        this.answer = answer;
    }

    public int getCorrect() {
        return correct;
    }

    public void setCorrect(int correct) {
        this.correct = correct;
    }
}
