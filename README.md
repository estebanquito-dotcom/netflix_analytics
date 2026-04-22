# Netflix Analytics

A Java console application developed for Dev Senior Code to practice Java Collections and Streams API for data analysis.

## Project Overview

This application simulates a data analytics system for a streaming platform. It processes user viewing data using Java Streams to generate statistics about movie consumption patterns, without using a database—data is managed through in-memory collections.

## Learning Objectives

The project focuses on mastering:

- Collections (List, Map, Set)
- Java Streams API
- Stream operations: filter(), map(), groupingBy(), sorted(), limit()
- Collectors for aggregation: counting(), summingInt(), averagingInt()
- Comparator for custom sorting
- Layered architecture pattern

## Key Concepts

- **Collections**: List stores ordered elements; Map stores key-value pairs; Set stores unique elements
- **Streams**: Functional approach to process data collections in a declarative way
- **Collectors**: Terminal operations that aggregate stream results into collections or single values

## Project Structure

```
analytics/
├── model/              # Domain entities
│   ├── Genre.java
│   ├── Movie.java
│   ├── User.java
│   └── View.java
├── repository/         # In-memory data layer
│   └── DataRepository.java
├── service/            # Business logic with Streams
│   └── AnalyticsService.java
├── ui/                 # Console interface
│   └── ConsoleUi.java
├── Main.java
└── resources/
    └── log4j2.xml
```

## Implemented Queries

### Core Requirements
1. Most viewed movies
2. Movies grouped by genre
3. Total viewing time per user
4. Top users by watch time
5. Average movie length by genre

### Additional Implementations
6. Movies watched by specific user
7. Most viewed genre
8. Movies ranked by total viewing time
9. Users filtered by specific watch time threshold

## Technologies

- Java 17
- Maven
- Log4j2 for logging

## Notes

All optional challenges were implemented in the AnalyticsService layer. The console interface focuses on the core requirements due to time constraints.
