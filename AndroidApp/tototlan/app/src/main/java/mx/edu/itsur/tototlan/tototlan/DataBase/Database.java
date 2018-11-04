package mx.edu.itsur.tototlan.tototlan.DataBase;

public class Database {

    public  final String STUDENT_TABLE = "Student";
    public  final String COLUMN_ID = "_idStudent";
    public  final String COLUMN_USER_NAME = "user";
    public  final String COLUMN_PASSWORD = "pass";
    public  final String COLUMN_EMAIL = "email";
    public  final  String COLUMN_facebookAccount = "facebookAccount";


    public  final String CREATE_TABLE = "create table " + STUDENT_TABLE + " (" +
            COLUMN_ID + " INTEGER PRIMARY KEY ," +
            COLUMN_USER_NAME + " TEXT," +
            COLUMN_PASSWORD + " TEXT," +
            COLUMN_EMAIL + " TEXT," +
            COLUMN_facebookAccount + " TEXT)";

}
