package mx.edu.itsur.tototlan.accesoDatos;

import android.database.sqlite.SQLiteException;

import java.util.List;
import java.util.Map;

public interface GenericoDAO <T> {

    public boolean agregar(T entidad) throws SQLiteException;

    public T obtener(long identificador) throws SQLiteException;

    public boolean modificar(T entidad) throws SQLiteException;

    public boolean eliminar(long identificador) throws  SQLiteException;

    public List<T> todos() throws  SQLiteException;

    public List<T> buscar(Map <String, Object> criterios) throws SQLiteException;




}
