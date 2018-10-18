package mx.edu.itsur.tototlan.accesoDatos;

import android.database.sqlite.SQLiteException;

import java.util.List;
import java.util.Map;

import mx.edu.itsur.tototlan.modelo.Examen;

public interface ExamenDAO extends GenericoDAO <Examen> {


    public boolean agregar(Examen entidad) throws SQLiteException;

    public Examen obtener(long identificador) throws SQLiteException;

    public boolean modificar(Examen entidad) throws SQLiteException;

    public boolean eliminar(long identificador) throws  SQLiteException;

    public List<Examen> todos() throws  SQLiteException;

    public List<Examen> buscar(Map<String, Object> criterios) throws SQLiteException;

}
