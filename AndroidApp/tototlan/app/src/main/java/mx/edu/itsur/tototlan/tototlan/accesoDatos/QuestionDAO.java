package mx.edu.itsur.tototlan.tototlan.accesoDatos;

import android.database.sqlite.SQLiteException;

import java.util.List;
import java.util.Map;


import mx.edu.itsur.tototlan.tototlan.modelo.Question;

public interface QuestionDAO extends GenericoDAO<Question>{


    public boolean add(Question entidad) throws SQLiteException;

    public Question get(long identificador) throws SQLiteException;

    public boolean update(Question entidad) throws SQLiteException;

    public boolean delete(long identificador) throws  SQLiteException;

    public List<Question> getAll() throws  SQLiteException;

    public List<Question> searh(Map<String, Object> criterios) throws SQLiteException;

}
