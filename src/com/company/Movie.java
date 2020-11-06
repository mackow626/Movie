package com.company;

import java.time.LocalDate;
import java.util.List;

public class Movie {
    String title;
    Director director;
    MovieType type;
    LocalDate premiereDate;
    List<Actors> actorsList;

    @Override
    public String toString() {
        return "Film" +
                "title='" + title + '\'' +
                ", director=" + director +
                ", type=" + type +
                ", premiereDate=" + premiereDate +
                ", actorsList=" + actorsList +
                '}';
    }

    public Movie(String title, Director director, MovieType type, LocalDate premiereDate, List<Actors> actorsList) {
        this.title = title;
        this.director = director;
        this.type = type;
        this.premiereDate = premiereDate;
        this.actorsList = actorsList;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }

    public MovieType getType() {
        return type;
    }

    public void setType(MovieType type) {
        this.type = type;
    }

    public LocalDate getPremiereDate() {
        return premiereDate;
    }

    public void setPremiereDate(LocalDate premiereDate) {
        this.premiereDate = premiereDate;
    }

    public List<Actors> getActorsList() {
        return actorsList;
    }

    public void setActorsList(List<Actors> actorsList) {
        this.actorsList = actorsList;
    }
}

