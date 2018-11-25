package mx.edu.itsur.tototlan.tototlan.accesoDatos;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import mx.edu.itsur.tototlan.tototlan.DataBase.DBhelper;
import mx.edu.itsur.tototlan.tototlan.DataBase.Database;
import mx.edu.itsur.tototlan.tototlan.modelo.Student;

public class StudentSQliteDAO extends Database implements GenericoDAO <Student> {

    private DBhelper mDbHelper;
    public StudentSQliteDAO(Context context) {
        mDbHelper = new DBhelper(context);
    }

    public StudentSQliteDAO(Context context, String databaseName, Object o, int databaseVersion) {
    }


    @Override
    public boolean add(Student entity) throws SQLiteException {
        SQLiteDatabase db = mDbHelper.getReadableDatabase();


        try {


            ContentValues values = new ContentValues();
            values.put(COLUMN_ID, entity.getIdStudent());
            values.put(COLUMN_USER_NAME, entity.getUser());
            values.put(COLUMN_PASSWORD, entity.getPass());
            values.put(COLUMN_EMAIL, entity.getEmail());
            values.put(COLUMN_facebookAccount, entity.getFacebookAccount());

            db.insert(STUDENT_TABLE, null, values);


            return true;
        } catch (SQLException ex) {
            Log.w("SQLException", ex.fillInStackTrace());

            return false;
        } finally {
            if (db != null) {
                db.close();
            }
        }
    }


    @Override

    public Student get(long identifier) throws SQLiteException {
        SQLiteDatabase db = mDbHelper.getReadableDatabase();


        try {
            Cursor cursor = db.query("Students", null, null, null, null, null, null);
            cursor.moveToFirst();
            Student student = new Student();
            student.setIdStudent(cursor.getString(0));
            student.setUser(cursor.getString(1));
            student.setPass(cursor.getString(2));
            student.setEmail(cursor.getString(3));
            student.setFacebookAccount(cursor.getString(4));


            return student;
        } catch (SQLException ex) {
            Log.w("SQLException", ex.fillInStackTrace());

        } finally {
            if (db != null) {
                db.close();
            }
        }

        return null;
    }

    @Override
    public boolean update(Student entity) throws SQLiteException {
        SQLiteDatabase db = mDbHelper.getWritableDatabase();

        try {


            ContentValues values = new ContentValues();
            values.put(COLUMN_ID, entity.getIdStudent());
            values.put(COLUMN_USER_NAME, entity.getUser());
            values.put(COLUMN_PASSWORD, entity.getPass());
            values.put(COLUMN_EMAIL, entity.getEmail());
            values.put(COLUMN_facebookAccount, entity.getFacebookAccount());


            String selection = COLUMN_USER_NAME + " = ?";
            String[] selectionArgs = {entity.getIdStudent() + ""};

            db.update(STUDENT_TABLE, values, selection, selectionArgs);

            return true;
        } catch (SQLException ex) {
            Log.w("SQLException", ex.fillInStackTrace());

        } finally {
            if (db != null) {
                db.close();
            }
        }


        return false;
    }

    @Override
    public boolean delete(long identifier) throws SQLiteException {
        SQLiteDatabase db = mDbHelper.getWritableDatabase();


        try {

            String selection = COLUMN_ID + " = ?";

            String[] selectionArgs = {String.valueOf(identifier)};

            db.delete(STUDENT_TABLE, selection, selectionArgs);


            return true;
        } catch (SQLException ex) {
            Log.w("SQLException", ex.fillInStackTrace());

        } finally {
            if (db != null) {
                db.close();
            }
        }

        return false;
    }

    @Override
    public List<Student> getAll() throws SQLiteException {

        List<Student> studentList = new ArrayList<Student>();
        SQLiteDatabase db = mDbHelper.getReadableDatabase();

        Cursor cursor = db.query("Student", null, null, null, null, null, null);

        while (cursor.moveToNext()) {
            Student student = new Student();
            student.setIdStudent(cursor.getString(0));
            student.setUser(cursor.getString(1));
            student.setPass(cursor.getString(2));
            student.setEmail(cursor.getString(3));
            student.setFacebookAccount(cursor.getString(4));
            studentList.add(student);
        }

        return studentList;
    }

    @Override
    public List<Student> find(Map<String, Object> criteria) throws SQLiteException {
        SQLiteDatabase db = mDbHelper.getReadableDatabase();
        Set<String> columns = criteria.keySet();
        List<Student> studentList = new ArrayList<Student>();
        String filter = "";
        String[] columnsString = (String[]) columns.toArray();

        for (int i = 0; i < columns.size() - 2; i++) {
            filter += columnsString[i] + "= ?, ";
        }
        filter += columnsString[columns.size() - 1] + "= ?";

        String[] values = new String[columns.size()];

        for (int i = 0; i < values.length - 1; i++) {
            values[i] = (String) criteria.get(columnsString[i]);
        }

        Cursor cursor = db.query("Student", null, filter, values, null, null, null);
        while (cursor.moveToNext()) {
            Student student = new Student();
            student.setIdStudent(cursor.getString(0));
            student.setUser(cursor.getString(1));
            student.setPass(cursor.getString(2));
            student.setEmail(cursor.getString(3));
            student.setFacebookAccount(cursor.getString(4));
            studentList.add(student);
        }
        return studentList;
    }

}