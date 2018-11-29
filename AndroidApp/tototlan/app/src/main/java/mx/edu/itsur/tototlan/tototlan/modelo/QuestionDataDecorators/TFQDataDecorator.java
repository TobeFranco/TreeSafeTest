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
 * True False Question Data Decorator
 */
public class TFQDataDecorator extends QuestionDataDecorator{
    private boolean correctAnswer;
    private boolean userAnswer;
    
    public TFQDataDecorator(QuestionData questionData) {
        super(questionData);
        deserialize();
        userAnswer = false;
    }
    
    private void deserialize(){
        int answerInt = gson.fromJson(questionData.getCorrect(), int.class);
        correctAnswer = answerInt == 1;
    }

    public boolean getCorrectAnswer() {
        return correctAnswer;
    }

    public boolean getUserAnswer() {
        return userAnswer;
    }

    public void setUserAnswer(boolean userAnswer) {
        this.userAnswer = userAnswer;
    }
    
    public String serializeUserAnswer() {
        int answerInt = (this.userAnswer) ? 1 : 0;
        return gson.toJson(answerInt, int.class);
    }
    
}
