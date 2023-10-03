package com.example.myapplication;

public class Player {
    private String name;
    private String nationality;
    private String description;
    private int image;

    public Player(String name, String nationality, String description, int image) {
        this.name = name;
        this.nationality = nationality;
        this.description = description;
        this.image = image;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", nationality='" + nationality + '\'' +
                ", description='" + description + '\'' +
                ", image=" + image +
                '}';
    }
}
