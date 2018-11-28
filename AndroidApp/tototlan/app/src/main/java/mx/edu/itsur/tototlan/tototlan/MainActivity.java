package mx.edu.itsur.tototlan.tototlan;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import mx.edu.itsur.tototlan.tototlan.Vista.QuestionFragment;
import mx.edu.itsur.tototlan.tototlan.accesoDatos.TestSQliteDAO;
import mx.edu.itsur.tototlan.tototlan.modelo.Answer;
import mx.edu.itsur.tototlan.tototlan.modelo.OpenQuestion;
import mx.edu.itsur.tototlan.tototlan.modelo.Question;
import mx.edu.itsur.tototlan.tototlan.modelo.QuestionData;
import mx.edu.itsur.tototlan.tototlan.modelo.SingleChoicesQuestions;
import mx.edu.itsur.tototlan.tototlan.modelo.Test;
import mx.edu.itsur.tototlan.tototlan.modelo.TrueFalseQuestion;


public class MainActivity extends AppCompatActivity {
// esto me causa problemas con la Autentificacion
    //private Answer answer= new Answer();
    //private SingleChoicesQuestions questions = new SingleChoicesQuestions();
    //private TrueFalseQuestion trueFalseQuestion = new TrueFalseQuestion();
    //private OpenQuestion openQuestion = new OpenQuestion();
    //private QuestionFragment questionFragment  = new QuestionFragment.QuestionFragmentBuilder(openQuestion,answer).build();
    //private FragmentTransaction transaction;

    TextView NumQuestion;
    Button Next;
    EditText Answers;
    Button logOutBtn;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        NumQuestion = findViewById(R.id.lblNumQuestion);
        Next = findViewById(R.id.btnNext);
        Answers = findViewById(R.id.txtAnswer);
        // NumQuestion.setText(question.getIdQuestion()+"");
        //determinado por la pregunta
        //Question.setText(question.getData().getstatement());
        //Creates los fragmentos y Transacciones de Fragmentos
        List<String> opciones = new ArrayList<>();
        opciones.add("op 1");
        opciones.add("op 2");
        opciones.add("op 3");
        //question.setChoices(opciones);
//        QuestionFragment questionFragment  = new QuestionFragment.QuestionFragmentBuilder(question,answer).build();

        //question.setType(QuestionData.QuestionType.OPEN);



        //comente esta otra parte de gio


      /*  answer.setAnswer("hola");
        transaction = getSupportFragmentManager().beginTransaction();
        if (questionFragment != null) {
            transaction.add(R.id.fragment_container, questionFragment);
            transaction.commit();
        }
            Next.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //aqui es donde puede cambiar el fragmento que desees
                    questionFragment = new QuestionFragment.QuestionFragmentBuilder(questions,answer).build();
                    CambiarFragmento();
                }
            });
        */



            logOutBtn = (Button) findViewById(R.id.logOutBtn);
            logOutBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
                    FirebaseAuth.getInstance().signOut();


                    Intent intent = new Intent(MainActivity.this, Login.class);
                    startActivity(intent);

                }
            });



            mx.edu.itsur.tototlan.tototlan.modelo.Test t = new mx.edu.itsur.tototlan.tototlan.modelo.Test();
            TestSQliteDAO sqTest = new TestSQliteDAO(getApplicationContext());

            //'2007-01-01 10:00:00'

            SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

            Time startingTime = new Time(100);


            //t.setIdTest(1);
            t.setDesciption("Examen facil");
            t.setGroupCode("123");
            t.setTeacherName("Tierritas");
            try {
                t.setStartDate(s.parse(obtenerFecha()));
                t.setEndDate(s.parse(obtenerFecha()));
                t.setTotalTime(startingTime);
            } catch (ParseException e) {
                Log.e("ERROR2", e.getMessage());
            }
            sqTest.add(t);
            t = sqTest.get(1);


            t.setIdTest(1);
            t.setDesciption("Examen dificil");
            sqTest.update(t);
            Toast.makeText(this, "ID" + t.getIdTest() + " tiempo" + t.getTotalTime() + " desc" + t.getDesciption(), Toast.LENGTH_LONG).show();


        }


        //Tambien comente esta otra parte gio

       /** private void CambiarFragmento () {
            transaction = getSupportFragmentManager().beginTransaction();
            if (questionFragment != null) {

                transaction.replace(R.id.fragment_container, questionFragment);
//            transaction.add(R.id.fragment_container, questionFragment);
                transaction.commit();
            }
        }

        */

        private String obtenerFecha () {
            Calendar cal = Calendar.getInstance();
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String fechaActual = format.format(cal.getTime());
            return fechaActual;
        }
    }

