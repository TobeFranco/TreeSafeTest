package mx.edu.itsur.tototlan.tototlan.modelo;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

import java.util.Set;

@Entity(foreignKeys =
@ForeignKey(entity = Student.class,
        parentColumns = "answersSheetID",
        childColumns = "studentID"))
public class AnswerSheet extends Question{

    @PrimaryKey
    private int answersSheetID;
    private int studentID;
    private Set<Answer> tanswer;
    private Student student;
    private Test test;

    public AnswerSheet( Test test) {
        this.test = test;
    }

    public int getAnswersSheetID(){
        return this.answersSheetID;
    }

    public void setAnswersSheetID(int id) {
        this.answersSheetID = id;
    }

    public Test getTest() {
        return test;
    }

    public void setTest(Test test) {
        this.test = test;
    }

    public Set<Answer> getTanswer() {
        return tanswer;
    }

    public void setTanswer(Set<Answer> tanswer) {
        this.tanswer = tanswer;
    }
}
