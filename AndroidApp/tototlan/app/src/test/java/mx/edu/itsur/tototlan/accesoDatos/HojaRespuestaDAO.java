package mx.edu.itsur.tototlan.accesoDatos;

import android.database.sqlite.SQLiteException;

import java.util.List;
import java.util.Map;

import mx.edu.itsur.tototlan.modelo.HojaRespuesta;

public interface HojaRespuestaDAO extends GenericoDAO <HojaRespuesta>{

    public boolean agregar(HojaRespuesta entidad) throws SQLiteException;

    public HojaRespuesta obtener(long identificador) throws SQLiteException;

    public boolean modificar(HojaRespuesta entidad) throws SQLiteException;

    public boolean eliminar(long identificador) throws  SQLiteException;

    public List<HojaRespuesta> todos() throws  SQLiteException;

    public List<HojaRespuesta> buscar(Map<String, Object> criterios) throws SQLiteException;

}
