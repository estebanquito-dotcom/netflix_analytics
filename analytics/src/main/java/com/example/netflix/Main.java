package com.example.netflix;

import com.example.netflix.ui.ConsoleUi;
import com.example.netflix.repository.DataRepository;
import com.example.netflix.service.AnalyticsService;

public class Main {

  

    public static void main(String[] args) {

        DataRepository repo = new DataRepository();
        AnalyticsService service = new AnalyticsService(repo);
        ConsoleUi console = new ConsoleUi(service);
        console.iniciar();
        
    }
}