package com.kveola13.hibernation;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "people")
public class Person {

    @Id
    private int id;
    private String name;
    private String nationality;

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

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }
}
