package mx.edu.itsur.tototlan.tototlan.modelo;

import com.owlike.genson.Genson;

public class OpenQuestion extends  Question{
    private Genson genson;
    private Question question;
    //Para accesar al tipo de pregunta se tiene que acceder al questiondata
    private QuestionData questionData;

    public OpenQuestion(Question question) {
        this.question = question;
        this.genson = new Genson();
        this.questionData.setType("Open");
        //this.question.setType(QuestionData.QuestionType.OPEN);
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
