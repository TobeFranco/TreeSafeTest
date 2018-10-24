package mx.edu.itsur.tototlan.accesoDatos;

import android.database.sqlite.SQLiteException;

import java.util.List;
import java.util.Map;

public interface RespuestaDAO extends GenericoDAO <Respuesta>{

    public boolean agregar(Respuesta entidad) throws SQLiteException;

    public Respuesta obtener(long identificador) throws SQLiteException;

    public boolean modificar(Respuesta entidad) throws SQLiteException;

    public boolean eliminar(long identificador) throws  SQLiteException;

    public List<Respuesta> todos() throws  SQLiteException;

    public List<Respuesta> buscar(Map<String, Object> criterios) throws SQLiteException;
}
