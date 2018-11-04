package mx.edu.itsur.tototlan.tototlan.DataBase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import mx.edu.itsur.tototlan.tototlan.accesoDatos.StudentSQliteDAO;

public class DBhelper extends StudentSQliteDAO {


    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Test.db";


    public DBhelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public DBhelper() {
        super();
    }


    public void onCreate(SQLiteDatabase db) {



        db.execSQL(CREATE_TABLE);
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String SQL_DELETE_STUDENDT_TABLE = "DROP TABLE IF EXISTS " + STUDENT_TABLE;
        db.execSQL(SQL_DELETE_STUDENDT_TABLE);
        onCreate(db);
    }

    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }


    public SQLiteDatabase getReadableDatabase() {
        return getReadableDatabase();
    }

    public SQLiteDatabase getWritableDatabase() {
        return  getReadableDatabase();
    }
}


