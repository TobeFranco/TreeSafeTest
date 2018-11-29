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

@Dao
public interface AnswerDAO extends GenericoDAO<Answer> {

    @Insert()
    boolean add(Answer entidad) throws SQLiteException;

    @Query("SELECT * FROM answers WHERE idAnswer = :identificador")
    Answer get(long identificador) throws SQLiteException;

    @Update()
    boolean update(Answer entidad) throws SQLiteException;

    @Delete()
    boolean delete(long identificador) throws  SQLiteException;

    @Query("SELECT * FROM answers")
    List<Answer> getAll() throws SQLiteException;

    public List<Answer> searh(Map<String, Object> criterios) throws SQLiteException;


}
