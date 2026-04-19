package com.example.netflix.service;


import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.logging.log4j.*;


import com.example.netflix.model.Genre;
import com.example.netflix.model.Movie;
import com.example.netflix.model.User;
import com.example.netflix.model.View;
import com.example.netflix.repository.DataRepository;

public class AnalyticsService {

    private static final Logger logger = LogManager.getLogger(AnalyticsService.class);
    
    //simulation db
    private DataRepository db;

    public AnalyticsService(DataRepository db){ //  <--instance already created
        //by the way isn't the same as new DataRepository(); <--new instance
        this.db = db;
        logger.info("Analytic service has initialized succesfully");
    }

    //return the most visualize movies
    public  List<Entry<Movie, Long>> topMovies(){
        //first at all, i get the list from the ""db"" simulation
        var result =db.views.stream().collect(Collectors
            .groupingBy(View::getMovie,Collectors.counting()))//group by same movie, and count how many times exist
            .entrySet().stream().sorted(Map.Entry //i got a map, but i need turn on stream to use sorted
            .<Movie,Long>comparingByValue().reversed()).limit(5).toList();//use reversed cause show in descendent and limit th return
            //i limited the return cause i dont have a many data. and turn into a List to show in UI.
        return result;
            
    }

    //return movies grouping by it genre
    //example Action: JHON WICK//AVENGERS//SUPERMAN
    public Map<Genre, List<Movie>> groupMoviesByGenre(){
        //i like using the var, cause it show me the return format
        var result = db.movies.stream()
        .collect(Collectors.groupingBy(Movie::getGenre));

        //here im not going to turn into a list cause the map works to
        //shows elements that compose a category
        return result;

    }

    //return the time that every user has spent watchin movies
    public Map<User,Integer>  spentTimeByUser(){
        // i used the var to see the return, and watch im getting what i need
        var result = db.views.stream()
        .collect(Collectors
        .groupingBy(View::getUser,Collectors.summingInt(View::getMinutes)));
        //it supposed that im getting this: Map <paquito , 200> 
        // and this works to handle the info in the UI
        //  and turn into this: paquito has watched 200 minutes
        return result;
    }

    //return top users,basically the users spend most time watching at platform
    //they didnt say me a limit but i'd say top 3 is enough

    public List<Entry<User,Integer>> topthreeSpentTime (){


        var result = db.views.stream()
        .collect(Collectors.groupingBy(View::getUser,Collectors
        .summingInt(View::getMinutes))).entrySet().stream()
        .sorted(Map.Entry.<User,Integer>comparingByValue().reversed()).limit(3).toList();
        
        return result;
    }

    //movies average length by genre

    public Map<Genre, Double> avgLengthByGenre(){
        var result = db.movies.stream().collect(Collectors.groupingBy(Movie::getGenre, Collectors.averagingInt(Movie::getLength)));
        return result;
    } 
    //at this point, i've completed all the project's requirements


    //OPTIONAL REQUIREMENTS
    //return the movies watched by user
    //ill use the id how usually do in db

    public Map<User, Set<String>> watchedMoviesByUser(int id){
        //ill use mapping, to clean the output, and return the data needed only.
        var result = db.views.stream().filter(r->r.getUser().getId()==id)
        .collect(Collectors.groupingBy(View::getUser,Collectors
        .mapping(v->v.getMovie().getTittle(),Collectors.toSet())));

        return result;


    }
    
    //OPTIONAL 
    //return most viewed genre

    public List<Entry<Genre,Long>> mostViewedGenre (){
        var result = db.views.stream().collect(Collectors
            .groupingBy(v->v.getMovie().getGenre(),Collectors
            .counting())).entrySet().stream()
            .sorted(Map.Entry.<Genre,Long>comparingByValue().reversed()).toList();

            return result;
    }

    //OPTIONAL
    //return most time played movie

    public List<Entry<Movie,Integer>> mostTimePlayed(){
        var result = db.views.stream()
        .collect(Collectors.groupingBy(View::getMovie,Collectors.summingInt(View::getMinutes)))
        .entrySet().stream()
        .sorted(Map.Entry.<Movie,Integer>comparingByValue().reversed()).limit(5).toList();

        return result;
    }

    //OPTIONAL
    //return User who spent x minutes, watching movies

    public List<String> minutesXSpentByUser(int time){

        var result = db.views.stream()
        .collect(Collectors.groupingBy(View::getUser,Collectors.summingInt(View::getMinutes)))
        .entrySet().stream().filter(r->r.getValue()==time).map(r->r.getKey().getName()).toList();

        return result;

    }

    //cause time im not going to implement the rest of optional challenges(methods)


}
