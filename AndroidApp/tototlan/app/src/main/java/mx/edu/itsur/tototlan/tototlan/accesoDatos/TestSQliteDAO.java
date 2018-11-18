package mx.edu.itsur.tototlan.tototlan.accesoDatos;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import mx.edu.itsur.tototlan.tototlan.DataBase.DBhelper;
import mx.edu.itsur.tototlan.tototlan.modelo.Test;

public class TestSQliteDAO implements GenericoDAO<Test> {

    private DBhelper myDbHelper;
    public TestSQliteDAO(Context context){
        myDbHelper = new DBhelper(context);
    }


    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    @Override
    public boolean add(Test test) throws SQLiteException {
        SQLiteDatabase db = myDbHelper.getWritableDatabase();
        try {
            ContentValues initialVaues = new ContentValues();
            // initialVaues.put("IDTEST",test.getIdTest());
            initialVaues.put("DESCRIPTION",test.getDesciption());
            initialVaues.put("START_DATE","'"+dateFormat.format(test.getStartDate())+"'");
            initialVaues.put("END_DATE","'"+dateFormat.format(test.getEndDate())+"'");
            initialVaues.put("TOTAL_TIME","'"+test.getTotalTime().toString()+"'");
            initialVaues.put("TEACHER_NAME",test.getTeacherName());
            initialVaues.put("GROUP_CODE",test.getGroupCode());

            db.insert("TEST",null,initialVaues);
            return true;
        }catch (Exception e){

            Log.e("ERROR",e.getMessage());
            return false;
        }

    }

    @Override
    public Test get(long idTest) throws SQLiteException {
        SQLiteDatabase db = myDbHelper.getReadableDatabase();
        Test test = new Test();


        String selection = "IDTEST = ?";
        String args[]= new String[]{idTest+""};
        Cursor cursor =db.query("TEST",null,selection,args,null,null,null,null);
        try {
            if(cursor != null){
                cursor.moveToFirst();
                test.setIdTest(cursor.getLong(0));
                test.setDesciption(cursor.getString(1));
                test.setStartDate(dateFormat.parse(cursor.getString(2).substring(1,cursor.getString(2).length()-1)));
                test.setEndDate(dateFormat.parse(cursor.getString(3).substring(1,cursor.getString(3).length()-1)));
                test.setTotalTime(Time.valueOf(cursor.getString(4).substring(1,cursor.getString(4).length()-1)));
                test.setTeacherName(cursor.getString(5));
                test.setGroupCode(cursor.getString(6));
            }
        }catch (Exception e){
            Log.e("ERROR",e.getMessage());
        }

        return test;
    }

    @Override
    public boolean update(Test test) throws SQLiteException {
        SQLiteDatabase db = myDbHelper.getReadableDatabase();
        try {
            ContentValues values = new ContentValues();
            values.put("DESCRIPTION",test.getDesciption());
            values.put("START_DATE","'"+dateFormat.format(test.getStartDate())+"'");
            values.put("END_DATE","'"+dateFormat.format(test.getEndDate())+"'");
            values.put("TOTAL_TIME","'"+test.getTotalTime().toString()+"'");
            values.put("TEACHER_NAME",test.getTeacherName());
            values.put("GROUP_CODE",test.getGroupCode());

            String where = "IDTEST = ?";
            String[] args = {test.getIdTest()+""};
            db.update("TEST",values,where,args);

            return true;
        }catch (Exception e){
            e.getMessage();
            return false;
        }
    }

    @Override
    public boolean delete(long idTest) throws SQLiteException {
        SQLiteDatabase db = myDbHelper.getWritableDatabase();

        try {
            String where = "where = ?";
            String[] args = {idTest+""};
            db.delete("TEST",where,args);
            return true;
        }catch (Exception e){
            e.getMessage();
            return false;
        }

    }

    @Override
    public List<Test> getAll() throws SQLiteException {
        List<Test> testList = new ArrayList<Test>();
        SQLiteDatabase db = myDbHelper.getReadableDatabase();
        Test test = new Test();

        try {
            Cursor cursor =db.query("TEST",null,null,null,null,null,null);
            while (cursor.moveToNext()){

                test.setIdTest(cursor.getLong(0));
                test.setDesciption(cursor.getString(1));
                test.setStartDate(dateFormat.parse(cursor.getString(2).substring(1,cursor.getString(2).length()-1)));
                test.setEndDate(dateFormat.parse(cursor.getString(3).substring(1,cursor.getString(3).length()-1)));
                test.setTotalTime(Time.valueOf(cursor.getString(4).substring(1,cursor.getString(4).length()-1)));
                test.setTeacherName(cursor.getString(5));
                test.setGroupCode(cursor.getString(6));
                testList.add(test);
            }
        }catch (Exception e){
            e.getMessage();
        }

        return testList;
    }

    @Override
    public List<Test> find(Map<String, Object> criterios) throws SQLiteException {
        SQLiteDatabase db = myDbHelper.getReadableDatabase();
        Test test = new Test();
        Set<String> columns= criterios.keySet();
        List<Test> testList = new ArrayList<Test>();
        String filter = "";
        String[] columnsString = (String[]) columns.toArray();
        for( int i = 0; i < columns.size()-2;i++){
            filter+=columnsString[i]+"= ?, ";
        }
        filter+=columnsString[columns.size()-1]+"= ?";

        String[] values = new String[columns.size()];

        for (int i = 0; i<values.length-1;i++){
            values[i] = (String)criterios.get(columnsString[i]);
        }
        try {
            Cursor cursor = db.query("TEST",null,filter,values,null,null,null);
            while (cursor.moveToNext()){
                test.setDesciption(cursor.getString(1));
                test.setStartDate(dateFormat.parse(cursor.getString(2).substring(1,cursor.getString(2).length()-1)));
                test.setEndDate(dateFormat.parse(cursor.getString(3).substring(1,cursor.getString(3).length()-1)));
                test.setTotalTime(Time.valueOf(cursor.getString(4).substring(1,cursor.getString(4).length()-1)));
                test.setTeacherName(cursor.getString(5));
                test.setGroupCode(cursor.getString(6));
                testList.add(test);
            }
        }catch (Exception e){
            e.getMessage();
        }

        return testList;
    }
}