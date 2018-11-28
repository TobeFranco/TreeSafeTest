package mx.edu.itsur.tototlan.tototlan.modelo;

import java.util.Objects;

public class QuestionData{

    public enum  QuestionType{OPEN, MULTIPLE_CHOICE, SINGLE_CHOICE, TRUE_FALSE, RELATIONAL}

    private QuestionType type;
    private String statement;
    private String answers;
    private String correct;

    public QuestionData() {
    }

    public QuestionData(QuestionType type, String statement, String answers, String correct) {
        this.type = type;
        this.statement = statement;
        this.answers = answers;
        this.correct = correct;
    }

    public QuestionType getType() {
        return type;
    }

    public void setType(QuestionType type) {
        this.type = type;
    }

    public String getStatement() {
        return statement;
    }

    public void setStatement(String statement) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        QuestionData that = (QuestionData) o;
        return getType() == that.getType() &&
                Objects.equals(getStatement(), that.getStatement()) &&
                Objects.equals(getAnswers(), that.getAnswers()) &&
                Objects.equals(getCorrect(), that.getCorrect());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getType(), getStatement(), getAnswers(), getCorrect());
    }

    @Override
    public String toString() {
        return "QuestionData{" +
                "type=" + type +
                ", statement='" + statement + '\'' +
                ", answers='" + answers + '\'' +
                ", correct='" + correct + '\'' +
                '}';
    }
}
