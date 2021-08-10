package com.example.CRUD.model;


import javax.persistence.*;

@Entity
public class Countries {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, name = "Id")
    private int Id;

    @Column(name = "country_name")
    private String country_name;

    public Countries() {
    }

    public Countries(String country_name) {
        this.country_name = country_name;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getCountry_name() {
        return country_name;
    }

    public void setCountry_name(String country_name) {
        this.country_name = country_name;
    }
}
