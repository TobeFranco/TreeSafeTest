package mx.edu.itsur.tototlan.tototlan.DataBase;

import android.arch.persistence.room.Database;
import mx.edu.itsur.tototlan.tototlan.accesoDatos.AnswerDAO;
import mx.edu.itsur.tototlan.tototlan.accesoDatos.AnswerSheetDAO;
import mx.edu.itsur.tototlan.tototlan.accesoDatos.QuestionDAO;
import mx.edu.itsur.tototlan.tototlan.accesoDatos.StudentDAO;
import mx.edu.itsur.tototlan.tototlan.accesoDatos.TestDAO;
import mx.edu.itsur.tototlan.tototlan.modelo.Answer;
import mx.edu.itsur.tototlan.tototlan.modelo.AnswerSheet;
import mx.edu.itsur.tototlan.tototlan.modelo.Question;
import mx.edu.itsur.tototlan.tototlan.modelo.Student;
import mx.edu.itsur.tototlan.tototlan.modelo.Test;

@Database(entities = {Answer.class, Question.class, Student.class, AnswerSheet.class, Test.class}, version = 1)
public abstract class AppDatabase {
    public abstract AnswerDAO answerDao();
    public abstract AnswerSheetDAO answersSheetDao();
    public abstract QuestionDAO questionDao();
    public abstract TestDAO testDao();
    public abstract StudentDAO studentDao();
}
