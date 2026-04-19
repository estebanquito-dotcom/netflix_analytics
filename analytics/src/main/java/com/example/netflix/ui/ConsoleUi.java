package com.example.netflix.ui;

import java.util.Scanner;

import com.example.netflix.service.AnalyticsService;

public class ConsoleUi {
    
    private AnalyticsService service;
    private Scanner sc;

    public ConsoleUi(AnalyticsService service){
        this.service = service;
        this.sc = new Scanner(System.in);
    }

    public void iniciar(){

        int option = -1;

        var menu = """
                    === NETFLIX ANALYTICS ===

                    1. Most Viewed Movies
                    2. Movies by Genre
                    3. Totally Time Watched by User
                    4. Top Users
                    5. Average by Genre
                    6. Movies Watched by User (id)
                    0. Exit
                """;

        do {

            switch (option) {
                case 1 -> showTopMovies();
                case 2 -> showMoviesByGenre();
                case 3 -> showTimeSpentByUser();
                case 4 -> showTopUsers();
                case 5 -> showAvgGenre();
                case 6 -> showMoviesWatchedByUser();

                
                
           
                default -> option=0 ;
                   
            }

            System.out.println(menu);
            option = sc.nextInt();
            
        } while (option!=0);

    }
    //obeying to modular programming, i separate the logic
    //in different methods.
    public void showTopMovies(){
        service.topMovies().forEach(r->System.out.println(r.getKey().getTittle()));

    }
    public void showMoviesByGenre(){
        service.groupMoviesByGenre().forEach((genre,movies)->{

            System.out.println("GENRE: "+ genre.name());

            movies.forEach(movie->System.out.println(movie.getTittle()));


        });
    }
    public void showTimeSpentByUser(){
        service.spentTimeByUser().forEach((user,time)->{
            System.out.println(user.getName()+" "+ time + " Minute/s");
        });
    }
    public void showTopUsers(){
        System.out.println("TOP 3 USERs: ");
        service.topthreeSpentTime().forEach(user->System.out.println(" - "+user.getKey().getName()));
    }
    public void showAvgGenre(){
        System.out.println("Length AVG by Genre: ");
        service.avgLengthByGenre().forEach((genre,time)->{
            System.out.println("Genre: "+genre.name()+ " AVG Time: "+time +" Minute/s");
        });
    }
    //this is the only interface for one of the optional requirements, so i added it as option 6 in the menu.
    public void showMoviesWatchedByUser(){
        System.out.println("Enter user id: ");
        int id = sc.nextInt();
        service.watchedMoviesByUser(id).forEach((user,movies)->{
            System.out.println("User: "+user.getName());
            movies.forEach(movie->System.out.println(" - "+movie));
        });
    }
    //cause time i didnt implement the rest of optional challenges.
}
