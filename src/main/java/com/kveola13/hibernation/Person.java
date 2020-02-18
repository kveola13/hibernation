package com.kveola13.hibernation;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "people")
@Cacheable
@Cache(usage= CacheConcurrencyStrategy.READ_ONLY)
public class Person {

    @Id
    private int id;
    private Name name;
    private String nationality;
    @OneToOne
    private University university;
    @OneToMany(mappedBy = "person", fetch = FetchType.EAGER)
    private List<Nation> nation = new ArrayList<Nation>();

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

    public University getUniversity() {
        return university;
    }

    public void setUniversity(University university) {
        this.university = university;
    }

    public List<Nation> getNation() {
        return nation;
    }

    public void setNation(List<Nation> nation) {
        this.nation = nation;
    }

    @Override
    public String toString() {
        return "Person [id= " + id + ", name= " + name + ", nationality= " + nationality + "]";
    }
}
