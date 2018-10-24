package mx.edu.itsur.tototlan.accesoDatos;

import android.database.sqlite.SQLiteException;

import java.util.List;
import java.util.Map;

import mx.edu.itsur.tototlan.modelo.Test;

public interface ExamenDAO extends GenericoDAO <Test> {


    public boolean agregar(Test entidad) throws SQLiteException;

    public Test obtener(long identificador) throws SQLiteException;

    public boolean modificar(Test entidad) throws SQLiteException;

    public boolean eliminar(long identificador) throws  SQLiteException;

    public List<Test> todos() throws  SQLiteException;

    public List<Test> buscar(Map<String, Object> criterios) throws SQLiteException;

}
