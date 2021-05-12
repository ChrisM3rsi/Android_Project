package com.example.drawer_test;
import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(tableName = "Omades",foreignKeys = {
        @ForeignKey(entity = Sports_Class_Local.class,
                parentColumns ="Sport_id",
                childColumns ="sportCode",
                onDelete = ForeignKey.CASCADE,
                onUpdate = ForeignKey.CASCADE
        )
})
public class Omada_Class_Local {

    @PrimaryKey
    @ColumnInfo(name="Oid")
    private int id;

    @ColumnInfo(name="nameGipedou")
    private String onomaGipedou;

    @ColumnInfo(name="nameOmadas")
    private String onomaOmadas;


    @ColumnInfo(name="gipedo")
    private String gipedo;

    @ColumnInfo(name="polh")
    private String polh;

    @ColumnInfo(name="origin")
    private String xwra;



    @ColumnInfo(name="sportCode")
    @NonNull
    private  int sportId;

    @ColumnInfo(name="Idrish")
    private String etosIdrisis;

    public void setId(int id) {
        this.id = id;
    }

    public void setOnomaGipedou(String onomaGipedou) {
        this.onomaGipedou = onomaGipedou;
    }
    public void setOnomaOmadas(String onomaOmadas) {
        this.onomaOmadas = onomaOmadas;
    }

    public void setGipedo(String gipedo) {
        this.gipedo = gipedo;
    }

    public void setPolh(String polh) {
        this.polh = polh;
    }

    public void setXwra(String xwra) {
        this.xwra = xwra;
    }

    public void setSportId(int sportId) {
        this.sportId = sportId;
    }

    public void setEtosIdrisis(String etosIdrisis) {
        this.etosIdrisis = etosIdrisis;
    }

    public int getId() {
        return id;
    }

    public String getOnomaGipedou() {
        return onomaGipedou;
    }

    public String getOnomaOmadas() {
        return onomaOmadas;
    }

    public String getGipedo() {
        return gipedo;
    }

    public String getPolh() {
        return polh;
    }

    public String getXwra() {
        return xwra;
    }

    public int getSportId() {
        return sportId;
    }

    public String getEtosIdrisis() {
        return etosIdrisis;
    }
}
