package com.example.drawer_test;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(tableName = "athletes",foreignKeys = {
        @ForeignKey(entity = Sports_Class_Local.class,
                parentColumns ="Sport_id",
                childColumns ="sportCode",
                onDelete = ForeignKey.CASCADE,
                onUpdate = ForeignKey.CASCADE
        )
})


public class Athlete_Class_Local {

    @Embedded
    public Sports_Class_Local sport;

    @PrimaryKey
    @ColumnInfo(name="aid")
    private int id;



    @ColumnInfo(name="name")
    private String onoma;

    @ColumnInfo(name="surname")
    private String epwnumo;

    @ColumnInfo(name="home")
    private String edra;

    @ColumnInfo(name="origin")
    private String xwra;



    @ColumnInfo(name="sportCode")
    @NonNull
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

    public String getXwra() {
        return xwra;
    }

    public void setXwra(String xwra) {
        this.xwra = xwra;
    }

    public Sports_Class_Local getSport() {
        return sport;
    }

    public void setSport(Sports_Class_Local sport) {
        this.sport = sport;
    }
}
