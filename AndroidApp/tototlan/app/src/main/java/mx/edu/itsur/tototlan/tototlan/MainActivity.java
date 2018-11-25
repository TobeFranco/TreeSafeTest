package mx.edu.itsur.tototlan.tototlan;

import android.content.Context;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import mx.edu.itsur.tototlan.tototlan.Vista.OpenQuestion;
import mx.edu.itsur.tototlan.tototlan.Vista.QuestionFragment;
import mx.edu.itsur.tototlan.tototlan.modelo.Answer;
import mx.edu.itsur.tototlan.tototlan.modelo.Question;
import mx.edu.itsur.tototlan.tototlan.modelo.QuestionData;
import mx.edu.itsur.tototlan.tototlan.modelo.SingleChoicesQuestions;

public class MainActivity extends AppCompatActivity {
    TextView NumQuestion;
    Button Next;
    EditText Answers;
    private mx.edu.itsur.tototlan.tototlan.modelo.OpenQuestion question = new mx.edu.itsur.tototlan.tototlan.modelo.OpenQuestion();
    private Answer answer= new Answer();
    private SingleChoicesQuestions questions = new SingleChoicesQuestions();
    //private QuestionFragment questionFragment;
    private QuestionFragment questionFragment  = new QuestionFragment.QuestionFragmentBuilder(question,answer).build();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        NumQuestion=findViewById(R.id.lblNumQuestion);
        //Question=findViewById(R.id.lblQuestion);
        Next=findViewById(R.id.btnNext);
        Answers=findViewById(R.id.txtAnswer);
        // NumQuestion.setText(question.getIdQuestion()+"");
        //determinado por la pregunta
        //Question.setText(question.getData().getstatement());
        //Creates los fragmentos y Transacciones de Fragmentos
        List<String> opciones =  new ArrayList<>();
        opciones.add("op 1");
        opciones.add("op 2");
        opciones.add("op 3");
        //question.setChoices(opciones);
//        QuestionFragment questionFragment  = new QuestionFragment.QuestionFragmentBuilder(question,answer).build();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        //question.setType(QuestionData.QuestionType.OPEN);
        answer.setAnswer("hola");
//        //Remplazar el fragmento en la vista
        if (questionFragment!=null) {
            transaction.add(R.id.fragment_container, questionFragment);
//        transaction.addToBackStack(null);
            transaction.commit();
        }
        Next.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast toast = new Toast(getApplicationContext());
                        //toast.setText(Toast.makeText(getApplicationContext(), answer.getAnswer(),Toast.LENGTH_SHORT));
                        Log.v("Respuesta",questionFragment.getAnswer());
            }
        });
    }
}
