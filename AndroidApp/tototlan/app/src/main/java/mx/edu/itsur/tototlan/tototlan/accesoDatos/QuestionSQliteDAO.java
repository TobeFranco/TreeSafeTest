package mx.edu.itsur.tototlan.tototlan.accesoDatos;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import mx.edu.itsur.tototlan.tototlan.DataBase.DBhelper;
import mx.edu.itsur.tototlan.tototlan.modelo.Question;
import mx.edu.itsur.tototlan.tototlan.modelo.QuestionData;
import mx.edu.itsur.tototlan.tototlan.modelo.QuestionType;

public class QuestionSQliteDAO implements GenericoDAO<Question> {

    private DBhelper mDBhelper;
    public QuestionSQliteDAO(Context context){ mDBhelper = new DBhelper(context);}

    @Override
    public boolean add(Question question) throws SQLiteException {

        SQLiteDatabase db = mDBhelper.getWritableDatabase();

        try{
            ContentValues values = new ContentValues();
            values.put("COLUMN_IDQUESTION",question.getIdQuestion());
            values.put("COLUMN_TYPE",question.getData().getType().toString());
            values.put("COLUMN_STATEMENT",question.getData().getStatement());
            values.put("COLUMN_ANSWERS",question.getData().getAnswers());
            values.put("COLUMN_CORRECT",question.getData().getCorrect());

            db.insert("QUESTIONS", null, values);
            return true;
        }catch (Exception e){
            Log.e("ERROR",e.getMessage());
            return false;
        }
    }

    @Override
    public Question get(long idQuestion) throws SQLiteException {

        SQLiteDatabase db = mDBhelper.getReadableDatabase();
        Question question = new Question();
        QuestionData questionData = new QuestionData();

        String selection = "IDQUESTION = ?";
        String args[]= new String[]{idQuestion+""};
        Cursor cursor =db.query("QUESTIONS",null,selection,args,null,null,null,null);
        try {
            if(cursor != null){
                cursor.moveToFirst();
                question.setIdQuestion(cursor.getLong(0));
                questionData.setType(QuestionType.valueOf(cursor.getString(1)));
                questionData.setStatement(cursor.getString(2));
                questionData.setAnswers(cursor.getString(3));
                questionData.setCorrect(cursor.getString(4));
                question.setData(questionData);
            }
        }catch (Exception e){
            Log.e("ERROR",e.getMessage());
        }

        return question;
    }

    @Override
    public boolean update(Question question) throws SQLiteException {
        SQLiteDatabase db = mDBhelper.getReadableDatabase();
        try {
            ContentValues values = new ContentValues();
            values.put("TYPE",question.getData().getType().toString());
            values.put("STATEMENT",question.getData().getStatement());
            values.put("ANSWERS",question.getData().getAnswers());
            values.put("CORRECT",question.getData().getCorrect());

            String where = "IDQUESTION = ?";
            String[] args = {question.getIdQuestion()+""};
            db.update("QUESTIONS",values,where,args);

            return true;
        }catch (Exception e){
            e.getMessage();
            return false;
        }
    }

    @Override
    public boolean delete(long idQuestion) throws SQLiteException {
        SQLiteDatabase db = mDBhelper.getWritableDatabase();

        try {
            String where = "where = ?";
            String[] args = {idQuestion+""};
            db.delete("QUESTIONS",where,args);
            return true;
        }catch (Exception e){
            e.getMessage();
            return false;
        }
    }

    @Override
    public List<Question> getAll() throws SQLiteException {
        List<Question> questionList = new ArrayList<Question>();
        SQLiteDatabase db = mDBhelper.getReadableDatabase();
        Question question = new Question();
        QuestionData questionData = new QuestionData();

        try {
            Cursor cursor =db.query("QUESTIONS",null,null,null,null,null,null);
            while (cursor.moveToNext()){

                question.setIdQuestion(cursor.getLong(0));
                questionData.setType(QuestionType.valueOf(cursor.getString(1)));
                questionData.setStatement(cursor.getString(2));
                questionData.setAnswers(cursor.getString(3));
                questionData.setCorrect(cursor.getString(4));
                question.setData(questionData);
                questionList.add(question);
            }
        }catch (Exception e){
            e.getMessage();
        }

        return questionList;
    }

    @Override
    public List<Question> find(Map<String, Object> criteries) throws SQLiteException {
        SQLiteDatabase db = mDBhelper.getReadableDatabase();
        Question question = new Question();
        QuestionData questionData = new QuestionData();

        Set<String> columns= criteries.keySet();

        List<Question> questionList = new ArrayList<Question>();

        String filter = "";
        String[] columnsString = (String[]) columns.toArray();
        for( int i = 0; i < columns.size()-2;i++){
            filter+=columnsString[i]+"= ?, ";
        }
        filter+=columnsString[columns.size()-1]+"= ?";

        String[] values = new String[columns.size()];

        for (int i = 0; i<values.length-1;i++){
            values[i] = (String)criteries.get(columnsString[i]);
        }
        try {
            Cursor cursor = db.query("QUESTIONS",null,filter,values,null,null,null);
            while (cursor.moveToNext()){

                question.setIdQuestion(cursor.getLong(0));
                questionData.setType(QuestionType.valueOf(cursor.getString(1)));
                questionData.setStatement(cursor.getString(2));
                questionData.setAnswers(cursor.getString(3));
                questionData.setCorrect(cursor.getString(4));
                question.setData(questionData);
                questionList.add(question);
            }
        }catch (Exception e){
            e.getMessage();
        }

        return questionList;
    }
}
