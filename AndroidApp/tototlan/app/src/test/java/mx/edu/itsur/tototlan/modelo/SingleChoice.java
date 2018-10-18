package mx.edu.itsur.tototlan.modelo;

import com.owlike.genson.GenericType;
import com.owlike.genson.Genson;

import java.util.List;

public class SingleChoice extends  Question{

    private Genson genson;
 private Question question;

    public SingleChoice(Question question) {
        this.question = question;
        this.genson = new Genson();

    }

    public void setStatement(String statement){
        this.question.getData().setstatement(statement);
    }
    public String getStatement(){
       return this.question.getData().getstatement();

    }


    public List<String> getChoices(){
       String json = question.getData().getAnswers();
       List<String> choises = genson.deserialize(json, new GenericType<List<String>>(){});
        return  choises;
    }

    public void setChoices(List<String> choices){
       String json = genson.serialize(choices);
       question.getData().setAnswers(json);
    }
}
