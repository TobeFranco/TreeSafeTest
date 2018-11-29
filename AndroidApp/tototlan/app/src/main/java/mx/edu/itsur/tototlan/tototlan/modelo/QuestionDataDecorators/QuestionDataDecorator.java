/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.itsur.tototlan.tototlan.modelo.QuestionDataDecorators;

import com.google.gson.Gson;
import mx.edu.itsur.tototlan.tototlan.modelo.QuestionData;
import mx.edu.itsur.tototlan.tototlan.modelo.QuestionType;

/**
 *
 * @author tobefranco
 * Single Choice Question Data Decorator
 */
public abstract class QuestionDataDecorator extends QuestionData {
    protected QuestionData questionData;
    protected final Gson gson;

    public QuestionDataDecorator(QuestionData questionData) {
        gson = new Gson();
        this.questionData = questionData;
    }

    public String getStatement() {
        return this.questionData.getStatement();
    }

    public void setStatement(String statement) {
        this.questionData.setStatement(statement);
    }

    @Override
    public String getAnswers() {
        return this.questionData.getAnswers();
    }

    @Override
    public void setAnswers(String answers) {
        this.questionData.setAnswers(answers);
    }

    @Override
    public String getCorrect() {
        return this.questionData.getCorrect();
    }

    @Override
    public void setCorrect(String correct) {
        this.questionData.setCorrect(correct);
    }

    @Override
    public QuestionType getType() {
        return this.questionData.getType();
    }

    @Override
    public void setType(QuestionType type) {
        this.questionData.setType(type);
    }

    public QuestionData getQuestionData() {
        return questionData;
    }

    public void setQuestionData(QuestionData questionData) {
        this.questionData = questionData;
    }
    
}
