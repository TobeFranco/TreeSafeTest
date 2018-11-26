package mx.edu.itsur.tototlan.tototlan.modelo;

import com.owlike.genson.GenericType;
import com.owlike.genson.Genson;

import java.util.List;

public class SingleChoicesQuestions extends  Question{

    private Genson genson;
    private Question question;
    //Para accesar al tipo de pregunta se tiene que acceder al questiondata
    private QuestionData questionData;

    public SingleChoicesQuestions(Question question) {
        this.question = question;
        this.genson = new Genson();
        this.questionData.setType("Single_Choice");
        //this.question.setType(QuestionData.QuestionType.SINGLE_CHOICE);
    }

    public SingleChoicesQuestions() {
        this(new Question());
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

    public QuestionData getData() {
        return this.question.getData();
    }

    public void setData(QuestionData data) {
        this.question.setData(data);
    }


}
