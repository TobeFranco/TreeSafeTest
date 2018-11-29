/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.itsur.tototlan.tototlan.TestService;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import java.lang.reflect.Type;

/**
 *
 * @author tobefranco
 */
public class QuestionDeserializer implements JsonDeserializer<ServiceQuestion>{

    @Override
    public ServiceQuestion deserialize(JsonElement je, Type type, JsonDeserializationContext jdc) throws JsonParseException {
        JsonObject object = je.getAsJsonObject();
        String Questiontype = object.get("type").getAsString();
        switch(Questiontype){
            case "OpenQuestion":
                return jdc.deserialize(je, OpenQuestion.class);
            case "MultipleChoice":
                return jdc.deserialize(je, MultipleChoice.class);
            case "MatchQuestion":
                return jdc.deserialize(je, MatchQuestion.class);
            case "TrueFalseQuestion":
                return jdc.deserialize(je, TrueFalseQuestion.class);
            case "SingleChoice":
                return jdc.deserialize(je, SingleChoiceQuestion.class);
            default:
                throw new IllegalArgumentException("Can't Deserialize " + je);
        }
    }
    
}
