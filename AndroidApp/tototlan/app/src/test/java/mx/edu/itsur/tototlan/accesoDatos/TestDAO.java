package mx.edu.itsur.tototlan.accesoDatos;

import android.database.sqlite.SQLiteException;

import java.util.List;
import java.util.Map;

import mx.edu.itsur.tototlan.modelo.Test;

public interface TestDAO extends GenericDAO<Test> {


    public boolean add(Test entidad) throws SQLiteException;

    public Test get(long identificador) throws SQLiteException;

    public boolean update(Test entidad) throws SQLiteException;

    public boolean delete(long identificador) throws  SQLiteException;

    public List<Test> all() throws  SQLiteException;

    public List<Test> searh(Map<String, Object> criterios) throws SQLiteException;

}
