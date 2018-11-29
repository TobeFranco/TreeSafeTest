package mx.edu.itsur.tototlan.tototlan.accesoDatos;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;
import android.database.sqlite.SQLiteException;

import java.util.List;
import java.util.Map;

import mx.edu.itsur.tototlan.tototlan.modelo.Answer;
import mx.edu.itsur.tototlan.tototlan.modelo.AnswerSheet;

@Dao
public interface AnswerSheetDAO extends GenericoDAO<AnswerSheet> {

    @Insert()
    boolean add(Answer entidad) throws SQLiteException;

    AnswerSheet get(long identificador) throws SQLiteException;

    @Update()
    boolean update(AnswerSheet entidad) throws SQLiteException;

    @Delete()
    boolean delete(long identificador) throws  SQLiteException;

    @Query("SELECT * FROM AnswerSheet")
    List<AnswerSheet> getAll() throws  SQLiteException;

    public List<AnswerSheet> searh(Map<String, Object> criterios) throws SQLiteException;

}
