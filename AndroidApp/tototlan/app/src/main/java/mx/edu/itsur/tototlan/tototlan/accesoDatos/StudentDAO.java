package mx.edu.itsur.tototlan.tototlan.accesoDatos;

import android.database.sqlite.SQLiteException;

import java.util.List;
import java.util.Map;

import mx.edu.itsur.tototlan.tototlan.modelo.Student;

interface StudentDAO extends GenericoDAO<Student>{


    @Override
    public boolean add(Student entity) throws SQLiteException;

    @Override
    public Student get(long idStudent) throws SQLiteException;


    @Override
    public boolean update(Student entity) throws SQLiteException;

    @Override
    public boolean delete(long idStudent) throws SQLiteException;

    @Override
    public List<Student> getAll() throws SQLiteException;

    @Override
    public List<Student> find(Map<String, Object> criteria) throws SQLiteException;
}

