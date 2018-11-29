package mx.edu.itsur.tototlan.tototlan.modelo;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "answers",
        foreignKeys = {
                @ForeignKey(entity = AnswerSheet.class,
                        parentColumns = "answerID",
                        childColumns = "answersSheetID"),
                @ForeignKey(entity = Question.class,
                        parentColumns = "answerID",
                        childColumns = "questionID")})
public class Answer implements Serializable{

    @PrimaryKey
    private long idAnswer;
    private int answersSheetID;
    private String answer;
    private float evaluation;
    private Question question;
    private AnswerSheet answerSheet;



    public Answer(long identificador) {
        this.idAnswer = identificador;
    }

    public Answer(){

    }


    public long getIdAnswer() {
        return idAnswer;
    }

    public void setIdAnswer(long idAnswer) {
        this.idAnswer = idAnswer;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public float getEvaluation() {
        return evaluation;
    }

    public void setEvaluation(float evaluation) {
        this.evaluation = evaluation;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public AnswerSheet getAnswerSheet() {
        return answerSheet;
    }

    public void setAnswerSheet(AnswerSheet answerSheet) {
        this.answerSheet = answerSheet;
    }
}
