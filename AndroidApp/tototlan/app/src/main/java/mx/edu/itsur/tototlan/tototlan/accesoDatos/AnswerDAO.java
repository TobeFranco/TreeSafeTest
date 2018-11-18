package mx.edu.itsur.tototlan.tototlan.accesoDatos;

import android.database.sqlite.SQLiteException;

import java.util.List;
import java.util.Map;

import mx.edu.itsur.tototlan.tototlan.modelo.Answer;


public interface AnswerDAO   extends GenericoDAO< Answer>{

    public boolean add(Answer entidad) throws SQLiteException;

    public  Answer get(long identificador) throws SQLiteException;

    public boolean update(Answer entidad) throws SQLiteException;

    public boolean delete(long identificador) throws  SQLiteException;

    public List< Answer> all() throws  SQLiteException;

    public List< Answer> searh(Map<String, Object> criterios) throws SQLiteException;


}
