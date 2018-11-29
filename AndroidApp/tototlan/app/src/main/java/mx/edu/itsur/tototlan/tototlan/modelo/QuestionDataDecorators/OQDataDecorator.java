/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.itsur.tototlan.tototlan.modelo.QuestionDataDecorators;


import mx.edu.itsur.tototlan.tototlan.modelo.QuestionData;

/**
 *
 * @author tobefranco
 */
public class OQDataDecorator extends QuestionDataDecorator{
    private String userAnswer;
    
    public OQDataDecorator(QuestionData questionData) {
        super(questionData);
        userAnswer = "";
    }

    public String getUserAnswer() {
        return userAnswer;
    }

    public void setUserAnswer(String userAnswer) {
        this.userAnswer = userAnswer;
    }
    
    public String serializeUserAnswer() {
        return gson.toJson(userAnswer, String.class);
    }
    
}
