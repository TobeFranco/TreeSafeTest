package mx.edu.itsur.tototlan.accesoDatos;

import android.database.sqlite.SQLiteException;

import java.util.List;
import java.util.Map;

import mx.edu.itsur.tototlan.modelo.Alumno;

class AlumnoSQliteDAO implements AlumnoDAO {
    @Override
    public boolean agregar(Alumno entidad) throws SQLiteException {
        return false;
    }

    @Override
    public Alumno obtener(long identificador) throws SQLiteException {
        return null;
    }

    @Override
    public boolean modificar(Alumno entidad) throws SQLiteException {
        return false;
    }

    @Override
    public boolean eliminar(long identificador) throws SQLiteException {
        return false;
    }

    @Override
    public List<Alumno> todos() throws SQLiteException {
        return null;
    }

    @Override
    public List<Alumno> buscar(Map<String, Object> criterios) throws SQLiteException {
        return null;
    }
}
