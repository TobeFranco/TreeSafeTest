package mx.edu.itsur.tototlan.accesoDatos;

import android.database.sqlite.SQLiteException;

import java.util.List;
import java.util.Map;

import mx.edu.itsur.tototlan.modelo.Question;

public interface PreguntaDAO extends GenericDAO<Question> {

    public boolean agregar(Question entidad) throws SQLiteException;

    public Question obtener(long identificador) throws SQLiteException;

    public boolean modificar(Question entidad) throws SQLiteException;

    public boolean eliminar(long identificador) throws  SQLiteException;

    public List<Question> todos() throws  SQLiteException;

    public List<Question> buscar(Map<String, Object> criterios) throws SQLiteException;


}
