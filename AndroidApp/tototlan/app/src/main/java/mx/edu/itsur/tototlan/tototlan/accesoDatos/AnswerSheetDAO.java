package mx.edu.itsur.tototlan.tototlan.accesoDatos;

import android.database.sqlite.SQLiteException;

import java.util.List;
import java.util.Map;

import mx.edu.itsur.tototlan.tototlan.modelo.AnswerSheet;

public interface AnswerSheetDAO extends GenericoDAO< AnswerSheet> {


    public boolean add( AnswerSheet entidad) throws SQLiteException;

    public  AnswerSheet get(long identificador) throws SQLiteException;

    public boolean update( AnswerSheet entidad) throws SQLiteException;

    public boolean delete(long identificador) throws  SQLiteException;

    public List< AnswerSheet> all() throws  SQLiteException;

    public List< AnswerSheet> searh(Map<String, Object> criterios) throws SQLiteException;

}
