package com.example.drawer_test;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Sports_Class_Local.class, athlete_Class_Local.class}, version = 1)
public abstract class Sports_Db_Local  extends RoomDatabase {
    public abstract myDao myDao();
}
