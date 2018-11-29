package mx.edu.itsur.tototlan.tototlan.Vista;

import android.support.v4.app.Fragment;

import mx.edu.itsur.tototlan.tototlan.modelo.Answer;
import mx.edu.itsur.tototlan.tototlan.modelo.OpenQuestion;
import mx.edu.itsur.tototlan.tototlan.modelo.Question;
import mx.edu.itsur.tototlan.tototlan.modelo.QuestionData;
import mx.edu.itsur.tototlan.tototlan.modelo.SingleChoicesQuestions;
import mx.edu.itsur.tototlan.tototlan.modelo.TrueFalseQuestion;


public abstract class QuestionFragment extends Fragment {
    private String question;

    public String getQuestion() {
        return question;
    }
    public abstract String getAnswer();

    public static class QuestionFragmentBuilder {
        private Question question;
        private Answer answer;
        private QuestionFragment QUESTIONS;

        public QuestionFragmentBuilder(Question question, Answer answer) {
            this.question = question;
            this.answer=answer;
        }

        public QuestionFragment build() {

           // if (question.getData().getType()== QuestionData.QuestionType.OPEN) {
                QuestionFragment questionFragment = OpenQuestionFragment.newInstance((OpenQuestion)question,answer);
                QUESTIONS=questionFragment;
            //}
           // if (question.getData().getType()== QuestionData.QuestionType.SINGLE_CHOICE) {
                QuestionFragment questionFragment1 = SingleChoice.newInstance((SingleChoicesQuestions) question, answer);
                QUESTIONS=questionFragment1;
           // }
            //if (question.getData().getType()== QuestionData.QuestionType.TRUE_FALSE) {
                QuestionFragment questionFragment2 = TrueFalseQuestionFragment.newInstance((TrueFalseQuestion)question, answer);
                QUESTIONS=questionFragment2;
           // }
            return QUESTIONS;
        }
    }

}

