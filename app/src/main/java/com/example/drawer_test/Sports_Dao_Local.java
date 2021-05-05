package com.example.drawer_test;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface Sports_Dao_Local {
    @Insert
    public void  addSport(Sports_Class_Local sport);

    @Query("Select * from Sports")
    public List<Sports_Class_Local> getSports();

    @Delete
    public  void DeleteSport(Sports_Class_Local sport);

    @Update
    public  void updateSport(Sports_Class_Local sport);
}
