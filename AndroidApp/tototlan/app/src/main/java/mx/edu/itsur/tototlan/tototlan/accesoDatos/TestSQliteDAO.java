package mx.edu.itsur.tototlan.tototlan.accesoDatos;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import mx.edu.itsur.tototlan.tototlan.modelo.Test;

public class TestSQliteDAO implements GenericoDAO<Test> {

    SimpleDateFormat date = new SimpleDateFormat("YYYY-MM-DD");
    @Override
    public boolean add(Test test) throws SQLiteException {
        SQLiteDatabase db;
        SQLiteOpenHelper dbH;
        dbH.getWritableDatabase();
        try {
            ContentValues initialVaues = new ContentValues();
            initialVaues.put("DESCRIPTION",test.getDesciption());
            initialVaues.put("START_DATE",test.getStartDate().toString());
            initialVaues.put("END_DATE",test.getEndDate().toString());
            initialVaues.put("TOTAL_TIME",test.getTotalTime().toString());
            initialVaues.put("TEACHER_NAME",test.getTeacherName().toString());
            initialVaues.put("GROUP_CODE",test.getGroupCode().toString());
            db.insert("TEST",null,initialVaues);
            return true;
        }catch (Exception e){
            e.getMessage();
            return false;
        }

    }

    @Override
    public Test get(long idTest) throws SQLiteException {

        SQLiteDatabase db;
        SQLiteOpenHelper dbH;
        dbH.getReadableDatabase();
        Test test = new Test();
        try{
            Cursor cursor =db.query("TEST",null,null,idTest,null,null,null);

            cursor.moveToFirst();

            test.setDesciption(cursor.getString(1));
            test.setStartDate(date.parse(cursor.getString(2)));
            test.setEndDate(date.parse(cursor.getString(3)));
            test.setTotalTime(Time.valueOf(cursor.getString(4)));
            test.setTeacherName(cursor.getString(5));
            test.setGroupCode(cursor.getString(6));
        } catch (Exception e) {
            e.getMessage();
        }

        return test;
    }

    @Override
    public boolean update(Test test) throws SQLiteException {
        SQLiteDatabase db;
        SQLiteOpenHelper dbH;
        dbH.getReadableDatabase();
        try {
            ContentValues values = new ContentValues();
            values.put("DESCRIPTION",test.getDesciption());
            values.put("START_DATE",test.getStartDate().toString());
            values.put("END_DATE",test.getEndDate().toString());
            values.put("TOTAL_TIME",test.getTotalTime().toString());
            values.put("TEACHER_NAME",test.getTeacherName().toString());
            values.put("GROUP_CODE",test.getGroupCode().toString());

            String where = "ID_TEST = ?";
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
        SQLiteDatabase db;
        SQLiteOpenHelper dbH;
        dbH.getWritableDatabase();

        try {
            String where = "where = "+idTest;
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
        SQLiteDatabase db;
        SQLiteOpenHelper dbH;
        dbH.getReadableDatabase();
        Test test = new Test();

        try {
            Cursor cursor =db.query("STUDENT",null,null,null,null,null,null);
            while (cursor.moveToNext()){

                test.setDesciption(cursor.getString(1));
                test.setStartDate(date.parse(cursor.getString(2)));
                test.setEndDate(date.parse(cursor.getString(3)));
                test.setTotalTime(Time.valueOf(cursor.getString(4)));
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
        SQLiteDatabase db;
        SQLiteOpenHelper dbH;
        dbH.getReadableDatabase();
        Test test = new Test();
        Set<String> columns= criterios.keySet();
        List<Test> testList = new ArrayList<Test>();
        String filter = "";
        Object[] columnsString = columns.toArray();
        for( int i = 0; i < columns.size()-2;i++){
            filter+=columnsString[i]+"= ?, ";
        }
        filter+=columnsString[columns.size()-1]+"= ?";

        Object[] values = new  Object[columns.size()];

        for (int i = 0; i<values.length-1;i++){
            values[i] = criterios.get(columnsString[i]);
        }

        try {
            Cursor cursor = db.query("STUDENT",null,filter,values,null,null,null);
            while (cursor.moveToNext()){
                test.setDesciption(cursor.getString(1));
                test.setStartDate(date.parse(cursor.getString(2)));
                test.setEndDate(date.parse(cursor.getString(3)));
                test.setTotalTime(Time.valueOf(cursor.getString(4)));
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