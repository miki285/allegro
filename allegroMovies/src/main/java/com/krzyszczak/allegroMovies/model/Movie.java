package com.krzyszczak.allegroMovies.model;

import java.util.Objects;


/**
 *
 */
public class Movie {
    private long id;
    private String title;
    private int year;
    private String director;

    public Movie(){
        id=0;
    }

    public Movie(long id, String title, int year, String director) {
        this.id = id;
        this.title = title;
        this.year = year;
        this.director = director;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;

    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;

    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Movie)) return false;
        Movie movie = (Movie) o;
        return  getYear() == movie.getYear() &&
                getTitle().equalsIgnoreCase(movie.getTitle()) &&
                getDirector().equalsIgnoreCase(movie.getDirector());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getId(), getTitle(), getYear(), getDirector());
    }

}
