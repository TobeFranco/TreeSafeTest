package mx.edu.itsur.tototlan.tototlan.modelo;

import com.owlike.genson.GenericType;
import com.owlike.genson.Genson;

import java.util.List;

public class OpenQuestion extends  Question{
    private Genson genson;
    private Question question;

    public OpenQuestion(Question question) {
        this.question = question;
        this.genson = new Genson();
        this.question.setType(QuestionData.QuestionType.OPEN);
    }

    public OpenQuestion() {
        this(new Question());
    }

    public void setStatement(String statement){
        this.question.getData().setstatement(statement);
    }

    public String getStatement(){
        return this.question.getData().getstatement();
    }

    public String getAnswer() {
        return question.getData().getAnswers();
    }

    public void setAnswer(String answer){
        question.getData().setAnswers(answer);
    }

    public QuestionData getData() {
        return this.question.getData();
    }

    public void setData(QuestionData data) {
        this.question.setData(data);
    }

}