package com.vasyancoder.laba2.data.db.entities;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "hackathon_table")
public class HackathonListItem {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "id")
    public Integer uid;

    @ColumnInfo(name = "name")
    public String name;
    @ColumnInfo(name = "company")
    public String company;
    @ColumnInfo(name = "dateStartEnd")
    public String dateStartEnd;
    @ColumnInfo(name = "languages")
    public String languages;
    @ColumnInfo(name = "status")
    public boolean status;

    public HackathonListItem(String name,
                             String company,
                             String dateStartEnd,
                             String languages,
                             boolean status) {
        this.name = name;
        this.company = company;
        this.dateStartEnd = dateStartEnd;
        this.languages = languages;
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public String getCompany() {
        return company;
    }

    public String getDateStartEnd() {
        return dateStartEnd;
    }

    public String getLanguages() {
        return languages;
    }

    public boolean isStatus() {
        return status;
    }
}
