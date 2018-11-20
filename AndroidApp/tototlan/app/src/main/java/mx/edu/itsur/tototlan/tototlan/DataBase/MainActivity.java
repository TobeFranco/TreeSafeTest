package mx.edu.itsur.tototlan.tototlan.DataBase;


import android.database.sqlite.SQLiteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.database.Cursor;
import android.widget.ListView;
import android.widget.Toast;

import junit.framework.Test;

import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import mx.edu.itsur.tototlan.tototlan.R;
import mx.edu.itsur.tototlan.tototlan.accesoDatos.TestSQliteDAO;
import mx.edu.itsur.tototlan.tototlan.modelo.Student;



public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
            Log.e("ERROR2",e.getMessage());
        }
        sqTest.add(t);
        t = sqTest.get(1);



        t.setIdTest(1);
        t.setDesciption("Examen dificil");
        sqTest.update(t);
        Toast.makeText(this,"ID"+t.getIdTest()+" tiempo" +t.getTotalTime() +" desc"+t.getDesciption(),Toast.LENGTH_LONG).show();

    }

    private String obtenerFecha(){
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String fechaActual = format.format(cal.getTime());
        return fechaActual;
    }
}
