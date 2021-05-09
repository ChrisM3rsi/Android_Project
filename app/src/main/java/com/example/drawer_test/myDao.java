package com.example.drawer_test;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface myDao {
    @Insert
    public void  addSport(Sports_Class_Local sport);

    @Query("Select * from Sports")
    public List<Sports_Class_Local> getSports();

    @Delete
    public  void deleteSport(Sports_Class_Local sport);

    @Update
    public  void updateSport(Sports_Class_Local sport);

    @Insert
    public  void addAthlete(athlete_Class_Local athlete);

    @Delete
    public void  deleteAthlete(athlete_Class_Local athlete);

    @Update
    public void updateAthlete(athlete_Class_Local athlete);

    @Query("Select * from athletes")
    public List<athlete_Class_Local> getAthletes();



}
