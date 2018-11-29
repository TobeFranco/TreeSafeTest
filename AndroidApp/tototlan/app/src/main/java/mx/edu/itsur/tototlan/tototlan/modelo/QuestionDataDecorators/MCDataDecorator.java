/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.itsur.tototlan.tototlan.modelo.QuestionDataDecorators;

import com.google.gson.reflect.TypeToken;

import mx.edu.itsur.tototlan.tototlan.modelo.QuestionData;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author tobefranco
 */
public class MCDataDecorator extends QuestionDataDecorator{
    private List<String> options;
    private List<Integer> correctAnswers;
    private List<Integer> userAnswers;
    
    public MCDataDecorator(QuestionData questionData) {
        super(questionData);
        deserialize();
        userAnswers = new ArrayList<>();
    }
    
    private void deserialize(){
        Type listStringType = new TypeToken<List<String>>(){}.getType();
        Type listIntType = new TypeToken<List<Integer>>(){}.getType();
        options = gson.fromJson(questionData.getAnswers(), listStringType);
        correctAnswers = gson.fromJson(questionData.getCorrect(), listIntType);
    }

    public List<String> getOptions() {
        return options;
    }

    public List<Integer> getCorrectAnswers() {
        return correctAnswers;
    }
    
    public String serializeUserAnswer() {
        Type listIntType = new TypeToken<List<Integer>>(){}.getType();
        return gson.toJson(userAnswers, listIntType);
    }
    
    public List<Integer> getUserAnswer() {
        return userAnswers;
    }
    
    public void setUserAnswer(List<Integer> userAnswers) {
        this.userAnswers = userAnswers;
    }
    
}
