package com.example.netflix.model;

public class Movie {

    private int id;
    private String tittle;
    private Genre genre;
    private int length;

    public Movie(int id, String tittle, Genre genre, int length) {
        this.id = id;
        this.tittle = tittle;
        this.genre = genre;
        this.length = length;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    @Override
    public String toString() {
        return "Movie [tittle=" + tittle + ", genre=" + genre + ", length=" + length + "]";
    }

    


    

}
