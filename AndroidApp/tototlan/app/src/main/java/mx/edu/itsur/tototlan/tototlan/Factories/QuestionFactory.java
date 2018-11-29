/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.itsur.tototlan.tototlan.Factories;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import mx.edu.itsur.tototlan.tototlan.modelo.QuestionDataDecorators.*;
import mx.edu.itsur.tototlan.tototlan.TestService.*;
import mx.edu.itsur.tototlan.tototlan.modelo.Question;
import mx.edu.itsur.tototlan.tototlan.modelo.QuestionData;
import mx.edu.itsur.tototlan.tototlan.modelo.QuestionType;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static mx.edu.itsur.tototlan.tototlan.modelo.QuestionType.*;

/**
 *
 * @author tobefranco
 */
public class QuestionFactory {
    
    private static final Gson gson;
    private static final Map<String, QuestionType> QUESTION_TYPE_MAP;
    static {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(ServiceQuestion.class, new QuestionDeserializer());
        gsonBuilder.registerTypeAdapter(ServiceQuestion.class, new QuestionSerializer());
        gson = gsonBuilder.create();
        QUESTION_TYPE_MAP = new HashMap<>();
        QUESTION_TYPE_MAP.put("OpenQuestion", OPEN);
        QUESTION_TYPE_MAP.put("MultipleChoice", MULTIPLE_CHOICE);
        QUESTION_TYPE_MAP.put("MatchQuestion", RELATIONAL);
        QUESTION_TYPE_MAP.put("TrueFalseQuestion", TRUE_FALSE);
        QUESTION_TYPE_MAP.put("SingleChoice", SINGLE_CHOICE);
    }
    
    /**
     * Creates a Question object from a ServiceQuestion object.
     * The resulting object has no deserialized answer and correct fields in QuestionData.
     * @param serviceQuestion 
     * @return Filled Question object from serviceQuestion data.
     */
    public static Question createQuestion(ServiceQuestion serviceQuestion){
        // Define types
        Type listStringType = new TypeToken<List<String>>() {}.getType();
        Type listIntegerType = new TypeToken<List<Integer>>() {}.getType();
        // Answers and Correct fields.
        String answers;
        String correct;
        // Determine Type
        switch(serviceQuestion.getType()){
            case "OpenQuestion":
                OpenQuestion oq = (OpenQuestion) serviceQuestion;
                answers = gson.toJson(oq.getAnswer(), String.class);
                correct = gson.toJson(oq.getAnswer(), String.class);
                break;
            case "MultipleChoice":
                MultipleChoice mcq = (MultipleChoice) serviceQuestion;
                answers = gson.toJson(mcq.getAnswer(), listStringType);
                correct = gson.toJson(mcq.getCorrect(), listIntegerType);
                break;
            case "MatchQuestion":
                MatchQuestion mq = (MatchQuestion) serviceQuestion;
                answers = gson.toJson(mq.getAnswer(), MatchQuestion.Options.class);
                Type mType = new TypeToken<List<MatchQuestion.Match>>() {}.getType();
                correct = gson.toJson(mq.getCorrect(), mType);
                break;
            case "TrueFalseQuestion":
                TrueFalseQuestion tfq = (TrueFalseQuestion) serviceQuestion;
                answers = gson.toJson(tfq.getAnswer(), listIntegerType);
                correct = gson.toJson(tfq.getCorrect(), int.class);
                break;
            case "SingleChoice":
                SingleChoiceQuestion scq = (SingleChoiceQuestion) serviceQuestion;
                answers = gson.toJson(scq.getAnswer(), listStringType);
                correct = gson.toJson(scq.getCorrect(), int.class);
                break;
            default:
                throw new RuntimeException("Unknown class");
        }
        // Create QuestionData
        QuestionData qdata = new QuestionData(
                QUESTION_TYPE_MAP.get(serviceQuestion.getType()),
                serviceQuestion.getSentence(), // Statement
                answers, // answers
                correct // Correct
                );
        // Create Question
        Question question = new Question();
        question.setIdQuestion(serviceQuestion.getId());
        question.setData(qdata);
        return question;
    }
    
    /**
     * Creates a decorated Question object.
     * The decorated object returned contains a decorated QuestionData object that
     * should be casted to the appropriate type.
     * The decorated QuestionData object within Question has defined structures for a better
     * manipulation.
     * @param sQuestion
     * @return question-type-decorated Question object.
     */
    public static Question createDecoratedQuestion(ServiceQuestion sQuestion) {
        Question question = QuestionFactory.createQuestion(sQuestion);
        switch(question.getData().getType()){
            case OPEN:
                OQDataDecorator oqd = new OQDataDecorator(question.getData());
                question.setData(oqd);
                break;
            case MULTIPLE_CHOICE:
                MCDataDecorator mcd = new MCDataDecorator(question.getData());
                question.setData(mcd);
                break;
            case RELATIONAL:
                MQDataDecorator mqd = new MQDataDecorator(question.getData());
                question.setData(mqd);
                break;
            case TRUE_FALSE:
                TFQDataDecorator tfqd = new TFQDataDecorator(question.getData());
                question.setData(tfqd);
                break;
            case SINGLE_CHOICE:
                SCQDataDecorator scd = new SCQDataDecorator(question.getData());
                question.setData(scd);
                break;
            default:
                throw new RuntimeException("Unknown class");
        }
        return question;
    }

    /**
     * Creates a list of Question objects based on the list of ServiceQuestion Objects passed.
     * @param sQuestions
     * @return
     */
    public static List<Question> createQuestions(List<ServiceQuestion> sQuestions){
        List<Question> questions = new ArrayList<>();
        for(ServiceQuestion sQuestion : sQuestions){
            Question question = QuestionFactory.createQuestion(sQuestion);
            questions.add(question);
        }
        return questions;
    }

    /**
     * Crates a lists of decorated Question Objects based on the list of Service Questions.
     * Each Question Object in the resulting list has a decorated QuestionData object and it should
     * be casted to the appropriate decorated type according to the Type field in QuestionData.
     * Example:
     * switch(question.getType()){
     *     case "OpenQuestion"
     * }
     * @param sQuestions
     * @return
     */
    public static List<Question> createDecoratedQuestions(List<ServiceQuestion> sQuestions){
        List<Question> questions = new ArrayList<>();
        for (ServiceQuestion sQuestion : sQuestions){
            Question question = QuestionFactory.createDecoratedQuestion(sQuestion);
            questions.add(question);
        }
        return questions;
    }
    
}
