package mx.edu.itsur.tototlan.accesoDatos;

import android.database.sqlite.SQLiteException;

import java.util.List;
import java.util.Map;

import mx.edu.itsur.tototlan.modelo.Student;

interface StudentDAO extends GenericoDAO<Student>{
    @Override
    public boolean agregar(Student entidad) throws SQLiteException;

    @Override
    public Student obtener(long identificador) throws SQLiteException;

    @Override
    public boolean modificar(Student entidad) throws SQLiteException;

    @Override
    public boolean eliminar(long identificador) throws SQLiteException;

    @Override
    public List<Student> todos() throws SQLiteException;

    @Override
    public List<Student> buscar(Map<String, Object> criterios) throws SQLiteException;
}

