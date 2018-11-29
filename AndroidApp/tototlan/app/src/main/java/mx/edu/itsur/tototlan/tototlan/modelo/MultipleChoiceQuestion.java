package mx.edu.itsur.tototlan.tototlan.modelo;

import com.owlike.genson.GenericType;
import com.owlike.genson.Genson;

import java.util.List;

public class MultipleChoiceQuestion extends Question{

    private Genson genson;

    public MultipleChoiceQuestion(){this (new Question());}

    public MultipleChoiceQuestion(Question question){
        this.setIdQuestion(question.getIdQuestion());
        QuestionData qd = question.getData();
        this.setData(qd);
    }

    public List<String> getChoices(){
        String json = this.getData().getAnswers();
        this.genson = new Genson();
        List<String> choices = genson.deserialize(json,new GenericType<List<String>>(){});
        return choices;
    }

    public void setChoices(List<String> choices){
        String json = genson.serialize(choices);
        this.genson = new Genson();
        this.getData().setAnswers(json);
    }
}
