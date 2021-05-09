package com.example.drawer_test;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "athletes")
public class athlete_Class_Local {
    @PrimaryKey
    @ColumnInfo(name="aid")
    private int id;

    @ColumnInfo(name="name")
    private String onoma;

    @ColumnInfo(name="surname")
    private String epwnumo;

    @ColumnInfo(name="home")
    private String edra;

    @ColumnInfo(name="sport code")
    private  int sportId;

    @ColumnInfo(name="born")
    private String etosGennisis;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOnoma() {
        return onoma;
    }

    public void setOnoma(String onoma) {
        this.onoma = onoma;
    }

    public String getEpwnumo() {
        return epwnumo;
    }

    public void setEpwnumo(String epwnumo) {
        this.epwnumo = epwnumo;
    }

    public String getEdra() {
        return edra;
    }

    public void setEdra(String edra) {
        this.edra = edra;
    }

    public int getSportId() {
        return sportId;
    }

    public void setSportId(int sportId) {
        this.sportId = sportId;
    }

    public String getEtosGennisis() {
        return etosGennisis;
    }

    public void setEtosGennisis(String etosGennisis) {
        this.etosGennisis = etosGennisis;
    }
}
