package com.uniguajira.proyectofinalv2.repositories.room.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.uniguajira.proyectofinalv2.repositories.room.entities.Revistas;

import java.util.List;

@Dao
public interface RevistasDao {
    @Query("SELECT * FROM revistas")
    LiveData<List<Revistas>> findAll();

    @Query("SELECT * FROM revistas WHERE id = :id")
    Revistas findByPk(int id);

    @Query("SELECT COUNT(*) from revistas")
    int count();

    @Insert()
    long insertOne(Revistas revista);

    @Insert
    void insertAll(List<Revistas> revista);

    @Delete
    void delete(Revistas revista);

    @Update
    void update(Revistas revista);
}
