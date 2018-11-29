package mx.edu.itsur.tototlan.tototlan.accesoDatos;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;
import android.database.sqlite.SQLiteException;

import java.util.List;
import java.util.Map;

import mx.edu.itsur.tototlan.tototlan.modelo.Student;

@Dao
public interface StudentDAO extends GenericoDAO<Student> {

    @Override
    @Insert()
    boolean add(Student entidad) throws SQLiteException;

    @Override
    @Query("SELECT * FROM students WHERE idStudent = :identificador")
    Student get(long identificador) throws SQLiteException;

    @Override
    @Update()
    boolean update(Student entidad) throws SQLiteException;

    @Override
    @Delete()
    boolean delete(long identificador) throws SQLiteException;

    @Override
    @Query("SELECT * FROM students")
    List<Student> getAll() throws SQLiteException;

    @Override
    public List<Student> find(Map<String, Object> criteria) throws SQLiteException;

}

