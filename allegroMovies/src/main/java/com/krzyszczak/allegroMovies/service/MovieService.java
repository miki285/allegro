package com.krzyszczak.allegroMovies.service;

import com.krzyszczak.allegroMovies.model.Movie;
import java.util.List;

public interface MovieService {
    Movie findById(long id);
    Movie findByName(String name);
    boolean saveMovie(Movie movie);
    List<Movie> findAllMovies();
}
