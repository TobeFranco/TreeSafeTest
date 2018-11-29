package mx.edu.itsur.tototlan.tototlan.modelo;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "questions")
public class Question implements Serializable {

    @PrimaryKey
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
