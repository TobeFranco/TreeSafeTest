package mx.edu.itsur.tototlan.tototlan.modelo;

import java.io.Serializable;

public class Question implements Serializable {

    private long idQuestion;
    private QuestionData data;

    public Question(QuestionData questionData) {
        this.data = questionData;
    }

    public Question(long idQuestion, QuestionData data) {
        this.idQuestion = idQuestion;
        this.data = data;
    }

    public Question() {
        this(new QuestionData());
    }

    public long getIdQuestion() {
        return idQuestion;
    }

    public void setIdQuestion(long idQuestion) {
        this.idQuestion = idQuestion;
    }

    public QuestionData getData() {
        return data;
    }

    public void setData(QuestionData data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Question{" +
                "idQuestion=" + idQuestion +
                ", data=" + data +
                '}';
    }
}
