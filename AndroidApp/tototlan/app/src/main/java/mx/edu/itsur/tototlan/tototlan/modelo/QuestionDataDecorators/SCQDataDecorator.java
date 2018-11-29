/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.itsur.tototlan.tototlan.modelo.QuestionDataDecorators;

import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.List;

import mx.edu.itsur.tototlan.tototlan.modelo.QuestionData;

/**
 *
 * @author tobefranco
 */
public class SCQDataDecorator extends QuestionDataDecorator {
    private List<String> options;
    private int correctAnswer;
    private int userAnswer;
    
    public SCQDataDecorator(QuestionData dataQuestion) {
        super(dataQuestion);
        deserialize();
        userAnswer = -1; // No answer
    }
    
    /**
     * Deserializes correct and answers attributes in DataQuestion
     */
    private void deserialize(){
        // Obtain List<String> type
        Type type = new TypeToken<List<String>>(){}.getType();
        // Obtain the options from answers in QuetsionData
        options = gson.fromJson(questionData.getAnswers(), type);
        
        // Obtain correctAnswer from correct in QuestionData
        correctAnswer = gson.fromJson(questionData.getCorrect(), int.class);
    }

    public int getCorrectAnswer() {
        return correctAnswer;
    }

    public List<String> getOptions() {
        return options;
    }
    
    public String serializeUserAnswer() {
        return gson.toJson(userAnswer, int.class);
    }
    
    public int getUserAnswer() {
        return userAnswer;
    }
    
    public void setUserAnswer(int userAnswer) {
        this.userAnswer = userAnswer;
    }

}
