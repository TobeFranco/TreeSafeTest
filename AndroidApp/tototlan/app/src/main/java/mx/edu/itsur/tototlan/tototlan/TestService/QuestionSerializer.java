/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.itsur.tototlan.tototlan.TestService;

import com.google.gson.JsonElement;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import java.lang.reflect.Type;

/**
 *
 * @author tobefranco
 */
public class QuestionSerializer implements JsonSerializer<ServiceQuestion>{

    @Override
    public JsonElement serialize(ServiceQuestion t, Type type, JsonSerializationContext jsc) {
        switch(t.getType()){
            case "OpenQuestion":
                return jsc.serialize(t, OpenQuestion.class);
            case "MultipleChoice":
                return jsc.serialize(t, MultipleChoice.class);
            case "MatchQuestion":
                return jsc.serialize(t, MatchQuestion.class);
            case "TrueFalseQuestion":
                return jsc.serialize(t, TrueFalseQuestion.class);
            case "SingleChoice":
                return jsc.serialize(t, SingleChoiceQuestion.class);
            default:
                throw new RuntimeException("Unknow class");
        }
    }
    
}
