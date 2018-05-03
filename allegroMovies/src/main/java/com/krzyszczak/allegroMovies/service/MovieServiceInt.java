package com.krzyszczak.allegroMovies.service;

import com.krzyszczak.allegroMovies.model.Movie;
import java.util.List;

public interface MovieServiceInt {
    Movie findById(long id);
    Movie findByTitle(String title);
    boolean addNew(Movie movie);
    List<String> findAll();
}
