package com.example.drawer_test;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Sports")
public class Sports_Class_Local {
    @PrimaryKey
    @ColumnInfo(name= "Sport_id")
    private int id;

    @ColumnInfo(name="Sport_name")
    private String name;

    @ColumnInfo(name="Sport_type")
    private String type;

    @ColumnInfo(name= "Sport_gender")
    private String gender;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
