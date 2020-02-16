package com.kveola13.hibernation;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "nation")
public class Nation {

    @Id
    private int id;
    private String name;
    private String continent;
    private String nationalLanguage;

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

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public String getNationalLanguage() {
        return nationalLanguage;
    }

    public void setNationalLanguage(String nationalLanguage) {
        this.nationalLanguage = nationalLanguage;
    }
}
