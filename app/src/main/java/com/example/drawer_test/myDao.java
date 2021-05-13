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
    public  void addAthlete(Athlete_Class_Local athlete);

    @Delete
    public void  deleteAthlete(Athlete_Class_Local athlete);

    @Update
    public void updateAthlete(Athlete_Class_Local athlete);

    @Query("Select * from athletes")
    public List<Athlete_Class_Local> getAthletes();

    @Query("Select * from Sports where Sport_id=:code")
    public Sports_Class_Local getSport(int code);

    @Query("Select * from athletes where aid=:code")
    public Athlete_Class_Local getAthlete(int code);

    @Query("Select * from athletes inner join Sports on athletes.sportCode=Sports.Sport_id")
    public List<Athlete_Class_Local> getAthletesSport();



    @Insert
    public void addTeam(Omada_Class_Local team);


    @Query("SELECT * from Omades")
    public List <Omada_Class_Local> getOmades();

    @Query("Select * from Omades where Oid=:code")
    public Omada_Class_Local getOmada(int code );

    @Delete
    public void deleteOmada(Omada_Class_Local omada);

}
