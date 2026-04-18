package com.example.netflix.model;

public class View {

    private User user;
    private Movie movie;
    private int minutes;


    public View(User user, Movie movie, int minutes) {
        this.user = user;
        this.movie = movie;
        this.minutes = minutes;
    }


    public User getUser() {
        return user;
    }


    public void setUser(User user) {
        this.user = user;
    }


    public Movie getMovie() {
        return movie;
    }


    public void setMovie(Movie movie) {
        this.movie = movie;
    }


    public int getMinutes() {
        return minutes;
    }


    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }


    @Override
    public String toString() {
        return "View [user=" + user + ", movie=" + movie + ", minutes=" + minutes + "]";
    }

    
    
    

}
