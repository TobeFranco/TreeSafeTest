package mx.edu.itsur.tototlan.tototlan.DataBase;

public class Database {
    //TABLE STUDENT
    public static final String STUDENT_TABLE = "Student";
    public static final String COLUMN_ID = "_idStudent";
    public static final String COLUMN_USER_NAME = "user";
    public static final String COLUMN_PASSWORD = "pass";
    public static final String COLUMN_EMAIL = "email";
    public static final  String COLUMN_facebookAccount = "facebookAccount";


    public static final String CREATE_TABLE = "create table " + STUDENT_TABLE + " (" +
            COLUMN_ID + " CHAR(9) PRIMARY KEY," +
            COLUMN_USER_NAME + " TEXT," +
            COLUMN_PASSWORD + " TEXT," +
            COLUMN_EMAIL + " TEXT," +
            COLUMN_facebookAccount + " TEXT)";

    //TABLE TEST
    private static final String TEST_TABLE= "TEST";
    private static final String COLUMN_IDTEST = "IDTEST";
    private static final String COLUMN_DESCRIPTION = "DESCRIPTION";
    private static final String COLUMN_START_DATE = "START_DATE";
    private static final String COLUMN_END_DATE = "END_DATE";
    private static final String COLUMN_TOTAL_TIME = "TOTAL_TIME";
    private static final String COLUMN_TEACHER_NAME = "TEACHER_NAME";
    private static final String COLUMN_GROUP_CODE = "GROUP_CODE";

    public static final String CREATE_TABLE_TEST = "create table " + TEST_TABLE +" (" +
            COLUMN_IDTEST + " INTEGER PRIMARY KEY AUTOINCREMENT," +
            COLUMN_DESCRIPTION + " TEXT," +
            COLUMN_START_DATE + " DATETIME," +
            COLUMN_END_DATE + " DATETIME," +
            COLUMN_TOTAL_TIME +" TIME," +
            COLUMN_TEACHER_NAME + " VARCHAR(50)," +
            COLUMN_GROUP_CODE + " VARCHAR(10) )";


    //TABLE QUESTIONS
    private static final String QUESTIONS_TABLE= "QUESTIONS";
    private static final String COLUMN_IDQUESTION = "IDQUESTION";
    private static final String COLUMN_TYPE = "TYPE";
    private static final String COLUMN_STATEMENT = "STATEMENT";
    private static final String COLUMN_ANSWERS = "ANSWERS";
    private static final String COLUMN_CORRECT = "CORRECT";

    public static final String CREATE_TABLE_QUESTIONS = "create table " + QUESTIONS_TABLE + " ("+
            COLUMN_IDQUESTION + " INTEGER PRIMARY KEY AUTOINCREMENT,"+
            COLUMN_TYPE + " TEXT CHECK( TYPE IN ('Open','Multiple_Choice','Single_Choice','True_False','Relational')),"+
            COLUMN_STATEMENT + "TEXT,"+
            COLUMN_ANSWERS + " TEXT,"+
            COLUMN_CORRECT + " CORRECT)";

    //TABLE TEST_HAS_QUESTIONS
    private static final String TEST_HAS_QUESTIONS_TABLE= "TEST_HAS_QUESTIONS";
    private static final String COLUMN_TEST_IDTEST = "TEST_IDTEST";
    private static final String COLUMN_QUESTIONS_IDQUESTION = "IDQUESTION";

    public static final String CREATE_TABLE_TEST_HAS_QUESTIONS = "create table " + TEST_HAS_QUESTIONS_TABLE + " ("+
            COLUMN_TEST_IDTEST + " INTEGER,"+
            COLUMN_QUESTIONS_IDQUESTION + " INTEGER," +
            "FOREIGN KEY("+COLUMN_TEST_IDTEST+") REFERENCES "+TEST_TABLE+" ("+COLUMN_IDTEST+"),"+
            "FOREIGN KEY("+COLUMN_QUESTIONS_IDQUESTION+") REFERENCES "+QUESTIONS_TABLE+" ("+COLUMN_IDQUESTION+"))";

    //TABLE STUDENTS
    private static final String ANSWERS_SHEET_TABLE= "ANSWERS_SHEET";
    private static final String COLUMN_IDANSWERS_SHEET= "IDANSWERS_SHHET";
    private static final String COLUMN_START_DATE_A = "START_DATE";
    private static final String COLUMN_END_DATE_A = "END_DATE";
    private static final String COLUMN_EVALUATION = "EVALUATION";
    private static final String COLUMN_STUDENTS_IDSTUDENTS = "STUDENTS_IDSTUDENT";

    public static final String CREATE_TABLE_ANSWERS_SHEET = "create table " + ANSWERS_SHEET_TABLE + " ("+
            COLUMN_IDANSWERS_SHEET + " INTEGER PRIMARY KEY AUTOINCREMENT,"+
            COLUMN_START_DATE_A + " DATETIME," +
            COLUMN_END_DATE_A + " DATETIME," +
            COLUMN_EVALUATION + " DATETIME," +
            COLUMN_STUDENTS_IDSTUDENTS + " CHAR(9)," +
            "FOREIGN KEY("+COLUMN_STUDENTS_IDSTUDENTS+") REFERENCES "+STUDENT_TABLE+" ("+COLUMN_ID+"))";

    //TABLE ANSWERS
    private static final String ANSWERS_TABLE= "ANSWERS";
    private static final String COLUMN_IDANSWER = "IDANSWER";
    private static final String COLUMN_ANSWER = "ANSWER";
    private static final String COLUMN_EVALUATION_A = "EVALUATION";
    private static final String COLUMN_QUESTIONS_IDQUESTION_A = "QUESTIONS_IDQUESTION";
    private static final String COLUMN_ANSWER_SHEET_IDANSWER_SHEET =  "ANSWER_SHEET_IDANSWER_SHEET";

    public static final String CREATE_TABLE_ANSWERS = "create table " + ANSWERS_TABLE + " ("+
            COLUMN_IDANSWER + " INTEGER PRIMARY KEY AUTOINCREMENT,"+
            COLUMN_ANSWER + " TEXT," +
            COLUMN_EVALUATION_A + " FLOAT," +
            COLUMN_QUESTIONS_IDQUESTION_A + " INITEGER(11)," +
            COLUMN_ANSWER_SHEET_IDANSWER_SHEET + " INTEGER," +
            "FOREIGN KEY("+COLUMN_QUESTIONS_IDQUESTION_A+") REFERENCES "+QUESTIONS_TABLE+" ("+COLUMN_IDQUESTION+"),"+
            "FOREIGN KEY("+COLUMN_ANSWER_SHEET_IDANSWER_SHEET+") REFERENCES "+ANSWERS_SHEET_TABLE+" ("+COLUMN_IDANSWERS_SHEET+"))";



}

