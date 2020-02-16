package com.kveola13.hibernation;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "people")
public class Person {

    @Id
    private int id;
    private Name name;
    private String nationality;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    @Override
    public String toString() {
        return "Person [id= " + id + ", name= " + name + ", nationality= " + nationality + "]";
    }
}
