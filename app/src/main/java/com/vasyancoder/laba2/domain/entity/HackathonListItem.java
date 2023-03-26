package com.vasyancoder.laba2.domain.entity;

public class HackathonListItem {

    private final String name;
    private final String company;
    private final String dateStartEnd;
    private final String languages;
    private final boolean status;

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
