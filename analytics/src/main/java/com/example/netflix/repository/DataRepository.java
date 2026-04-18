package com.example.netflix.repository;

import java.util.ArrayList;
import java.util.List;

import com.example.netflix.model.Genre;
import com.example.netflix.model.Movie;
import com.example.netflix.model.User;
import com.example.netflix.model.View;

public class DataRepository {


    public List<User> users = new ArrayList<User>();
    public List<Movie> movies = new ArrayList<Movie>();
    public List <View> views = new ArrayList<View>();

    public DataRepository(){

        User user1 = new User(1,"Esteban Moreno Roa"); 
        User user2 = new User(2,"Julian Martinez"); 
        User user3 = new User(3,"Paquito Corrales"); 
        User user4 = new User(4,"Juan Roa"); 
        User user5 = new User(4,"Francisco Garzon"); 

        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);
        users.add(user5);



        Movie movie1 = new Movie(1, "Matrix", Genre.SCI_FI, 140);
        Movie movie2 = new Movie(2, "The Avengers", Genre.ACTION, 140);
        Movie movie3 = new Movie(3, "Kill Bill", Genre.ACTION, 140);
        Movie movie4 = new Movie(4, "Batman", Genre.ACTION, 140);
        Movie movie5 = new Movie(5, "Super Man", Genre.ACTION, 140);
        Movie movie6 = new Movie(6, "Black Adam", Genre.ACTION, 140);
        Movie movie7 = new Movie(7,"Jhon Wick",Genre.ACTION,150);


        movies.add(movie1);
        movies.add(movie2);
        movies.add(movie3);
        movies.add(movie4);
        movies.add(movie5);
        movies.add(movie6);
        movies.add(movie7);

        View view1 = new View(user1, movie1, 110);
        View view2 = new View(user2, movie1, 110);
        View view3 = new View(user3, movie1, 110);
        View view4 = new View(user2, movie2, 50);
        View view5 = new View(user4, movie3, 30);
        View view6 = new View(user5, movie4, 100);
        View view7 = new View(user1, movie5, 10);
        View view8 = new View(user5, movie6, 5);
        View view9 = new View(user1, movie7, 80);

        views.add(view1);
        views.add(view2);
        views.add(view3);
        views.add(view4);
        views.add(view5);
        views.add(view6);
        views.add(view7);
        views.add(view8);
        views.add(view9);


    }
    

    


}
