package com.uniguajira.proyectofinalv2.repositories.room.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.uniguajira.proyectofinalv2.repositories.room.dao.RevistasDao;
import com.uniguajira.proyectofinalv2.repositories.room.entities.Revistas;

//Here initialise daos with respective tables
@Database(entities = {Revistas.class,}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    private static final String DATABASE_NAME = "my_database.db";
    private static AppDatabase sInstance;

    public abstract RevistasDao revistasDao();

    public static AppDatabase getAppDatabase(Context context) {
        if (sInstance == null) {
            sInstance = Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, DATABASE_NAME).allowMainThreadQueries().build();
        }
        return sInstance;
    }

    public static void destroyInstance() {
        sInstance = null;
    }
}
