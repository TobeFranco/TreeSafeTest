package mx.edu.itsur.tototlan.tototlan.DataBase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import mx.edu.itsur.tototlan.tototlan.accesoDatos.StudentSQliteDAO;

public class DBhelper extends SQLiteOpenHelper {


    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Test.db";


    public DBhelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Database.CREATE_TABLE);
        db.execSQL(Database.CREATE_TABLE_TEST);
        db.execSQL(Database.CREATE_TABLE_QUESTIONS);
        db.execSQL(Database.CREATE_TABLE_TEST_HAS_QUESTIONS);
        db.execSQL(Database.CREATE_TABLE_ANSWERS_SHEET);
        db.execSQL(Database.CREATE_TABLE_ANSWERS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }




}





