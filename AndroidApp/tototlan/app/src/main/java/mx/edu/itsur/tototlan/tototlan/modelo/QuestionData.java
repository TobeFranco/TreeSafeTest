package mx.edu.itsur.tototlan.tototlan.modelo;

import java.util.Objects;

public class QuestionData extends Question{

    //public enum  QuestionType{OPEN,MULTIPLE_CHOICE,SINGLE_CHOICE, TRUE_FALSE,RELATIONAL};
    private long IdQuestion;
    private String statement;
    private String answers;
    private String correct;
    //private QuestionType type;
    //Types {'Open','Multiple_Choice','Single_Choice','True_False','Relational'
    private String type;

    public QuestionData() {
    }


    public QuestionData(String statement, String answers, String correct, String type) {
        this.statement = statement;
        this.answers = answers;
        this.correct = correct;
        this.type = type;
    }

    public String getstatement() {
        return statement;
    }

    public long getIdQuestion() {
        return IdQuestion;
    }

    public void setIdQuestion(long idQuestion) {
        IdQuestion = idQuestion;
    }

    public void setstatement(String statement) {
        this.statement = statement;
    }

    public String getAnswers() {
        return answers;
    }

    public void setAnswers(String answers) {
        this.answers = answers;
    }

    public String getCorrect() {
        return correct;
    }

    public void setCorrect(String correct) {
        this.correct = correct;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        QuestionData that = (QuestionData) o;
        return Objects.equals(statement, that.statement) &&
                Objects.equals(answers, that.answers) &&
                Objects.equals(correct, that.correct) &&
                type == that.type;
    }

    @Override
    public int hashCode() {

        return Objects.hash(statement, answers, correct, type);
    }

    @Override
    public String toString() {
        return "QuestionData{" +
                "idQuestion ='" + this.getIdQuestion()+ '\'' +
                "statement='" + statement + '\'' +
                ", answers='" + answers + '\'' +
                ", correct='" + correct + '\'' +
                ", type=" + type +
                '}';
    }
}
