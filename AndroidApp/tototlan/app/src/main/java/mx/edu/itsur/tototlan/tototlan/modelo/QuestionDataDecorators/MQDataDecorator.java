/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.itsur.tototlan.tototlan.modelo.QuestionDataDecorators;

import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import mx.edu.itsur.tototlan.tototlan.modelo.QuestionData;


/**
 *
 * @author tobefranco
 * Match Question Data Decorator
 */
public class MQDataDecorator extends QuestionDataDecorator {
    private Options options;
    private List<Match> correctAnswers;
    private List<Match> userAnswers;
    
    public MQDataDecorator(QuestionData question) {
        super(question);
        deserialize();
        userAnswers = new ArrayList<>();
    }

    public List<Match> getUserAnswers() {
        return userAnswers;
    }

    public void setUserAnswers(List<Match> userAnswers) {
        this.userAnswers = userAnswers;
    }
    
    public String serializeUserAnswer() {
        Type type = new TypeToken<List<Match>>(){}.getType();
        return gson.toJson(userAnswers, type);
    }

    public Options getOptions() {
        return options;
    }

    public List<Match> getCorrectAnswers() {
        return correctAnswers;
    }
    
    /**
     * Deserializes correct and answers attributes in DataQuestion
     */
    private void deserialize(){
        // Obtain the options from answers in QuetsionData
        options = gson.fromJson(questionData.getAnswers(), Options.class);
        
        // Obtain List<Match>
        Type type = new TypeToken<List<Match>>(){}.getType();
        // Obtain correctAnswers from correct in QuestionData
        correctAnswers = gson.fromJson(questionData.getCorrect(), type);
    }
    
    public class Options {
        private List<String> leftOptions;
        private List<String> rightOptions;

        public List<String> getLeftOptions() {
            return leftOptions;
        }

        public void setLeftOptions(List<String> leftOptions) {
            this.leftOptions = leftOptions;
        }

        public List<String> getRightOptions() {
            return rightOptions;
        }

        public void setRightOptions(List<String> rightOptions) {
            this.rightOptions = rightOptions;
        }
    }
    
    public class Match {
        private int left;
        private int right;

        public int getLeft() {
            return left;
        }

        public void setLeft(int left) {
            this.left = left;
        }

        public int getRight() {
            return right;
        }

        public void setRight(int right) {
            this.right = right;
        }
    }
    
}
