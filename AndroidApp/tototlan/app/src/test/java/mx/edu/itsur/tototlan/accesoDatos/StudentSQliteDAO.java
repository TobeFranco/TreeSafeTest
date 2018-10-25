package mx.edu.itsur.tototlan.accesoDatos;

import android.database.sqlite.SQLiteException;

import java.util.List;
import java.util.Map;


import mx.edu.itsur.tototlan.modelo.Student;

class StudentSQliteDAO implements GenericDAO<Student> {
    @Override
    public boolean agregar(Student entidad) throws SQLiteException {
        return false;
    }

    @Override
    public Student obtener(long identificador) throws SQLiteException {
        return null;
    }

    @Override
    public boolean modificar(Student entidad) throws SQLiteException {
        return false;
    }

    @Override
    public boolean eliminar(long identificador) throws SQLiteException {
        return false;
    }

    @Override
    public List<Student> todos() throws SQLiteException {
        return null;
    }

    @Override
    public List<Student> buscar(Map<String, Object> criterios) throws SQLiteException {
        return null;
    }
}
