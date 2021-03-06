package com.kveola13.hibernation;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity(name = "nation")
public class Nation {

    @Id
    private int id;
    private String name;
    private String continent;
    private String nationalLanguage;
    @ManyToOne
    private Person person;

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

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public String toString() {
        return "Nation: " + name;
    }
}
