package mx.edu.itsur.tototlan.accesoDatos;

import android.database.sqlite.SQLiteException;

import java.util.List;
import java.util.Map;

public interface GenericDAO<T> {

    public boolean add(T entity) throws SQLiteException;

    public T get(long identifier) throws SQLiteException;

    public boolean update(T entity) throws SQLiteException;

    public boolean delete(long identifier) throws  SQLiteException;

    public List<T> getAll() throws  SQLiteException;

    public List<T> find(Map <String, Object> criteries) throws SQLiteException;




}
