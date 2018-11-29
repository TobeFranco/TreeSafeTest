package mx.edu.itsur.tototlan.tototlan.accesoDatos;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;
import android.database.sqlite.SQLiteException;

import java.util.List;
import java.util.Map;

import mx.edu.itsur.tototlan.tototlan.modelo.Test;

@Dao
public interface TestDAO extends GenericoDAO<Test> {

    @Insert()
    boolean add(Test entidad) throws SQLiteException;

    @Query("SELECT * FROM tests WHERE idTest = :identificador")
    Test get(long identificador) throws SQLiteException;

    @Update()
    boolean update(Test entidad) throws SQLiteException;

    @Delete()
    boolean delete(long identificador) throws  SQLiteException;

    @Query("SELECT * FROM tests")
    List<Test> getAll() throws  SQLiteException;

    public List<Test> searh(Map<String, Object> criterios) throws SQLiteException;

}
