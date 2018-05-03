package com.krzyszczak.allegroMovies.model;

import java.util.Objects;

public class Movie {
    private long id;
    private String title;
    private int year;
    private String director;

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
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", year=" + year +
                ", director='" + director + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Movie)) return false;
        Movie movie = (Movie) o;
        return getId() == movie.getId() &&
                getYear() == movie.getYear() &&
                Objects.equals(getTitle(), movie.getTitle()) &&
                Objects.equals(getDirector(), movie.getDirector());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getId(), getTitle(), getYear(), getDirector());
    }

}
