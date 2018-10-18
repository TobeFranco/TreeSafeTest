package mx.edu.itsur.tototlan.modelo;

public abstract class Question {

    private long idQuestion;
    private QuestionData data;


    public Question(QuestionData questionData) {
        this.data = questionData;
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
}
