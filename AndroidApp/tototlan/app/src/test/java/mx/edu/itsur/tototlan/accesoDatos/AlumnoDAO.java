package mx.edu.itsur.tototlan.accesoDatos;

import android.database.sqlite.SQLiteException;

import java.util.List;
import java.util.Map;

import mx.edu.itsur.tototlan.modelo.Alumno;

public interface AlumnoDAO extends GenericoDAO <Alumno>{

    public boolean agregar(Alumno entidad) throws SQLiteException;

    public Alumno obtener(long identificador) throws SQLiteException;

    public boolean modificar(Alumno entidad) throws SQLiteException;

    public boolean eliminar(long identificador) throws  SQLiteException;

    public List<Alumno> todos() throws  SQLiteException;

    public List<Alumno> buscar(Map<String, Object> criterios) throws SQLiteException;



}
