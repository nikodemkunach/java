package com.example.demo;


public class Animal {
    private int legNumber;
    private int age;
    private String name;
    private String species;

    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLegNumber() {
        return legNumber;
    }

    public void setLegNumber(int legNumber) {
        this.legNumber = legNumber;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public Animal(int legNumber, int age, String name, String species, int id) {
        this.legNumber = legNumber;
        this.age = age;
        this.name = name;
        this.species = species;
        this.id = id;
    }
}
