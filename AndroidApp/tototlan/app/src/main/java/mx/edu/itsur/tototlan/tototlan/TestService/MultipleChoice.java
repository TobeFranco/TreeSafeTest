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
public class MultipleChoice extends ServiceQuestion {
    private List<String> answer;
    private List<Integer> correct;

    public List<String> getAnswer() {
        return answer;
    }

    public void setAnswer(List<String> answer) {
        this.answer = answer;
    }

    public List<Integer> getCorrect() {
        return correct;
    }

    public void setCorrect(List<Integer> correct) {
        this.correct = correct;
    }
}
