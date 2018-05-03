package com.krzyszczak.allegroMovies.service;

import com.krzyszczak.allegroMovies.model.Movie;
import java.util.List;

public interface MovieServiceInt {
    Movie findById(long id);
    Movie findByTitle(String name);
    boolean addNew(Movie movie);
    List<Movie> findAll();
}
