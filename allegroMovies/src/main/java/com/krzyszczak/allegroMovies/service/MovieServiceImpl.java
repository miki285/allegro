package com.krzyszczak.allegroMovies.service;

import com.krzyszczak.allegroMovies.model.Movie;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;



@Service("movieService")
public class MovieServiceImpl implements MovieService {

    final AtomicLong orderIdGenerator=new AtomicLong(0);
    private static List<Movie> movies;

    public MovieServiceImpl() {
        movies=populateDummyMovies();
    }

    private List<Movie> populateDummyMovies() {
        List<Movie> movies= new ArrayList<Movie>();
        movies.add(new Movie(orderIdGenerator.incrementAndGet(), "Matrix", 1999, "Lilly Wachowski, Lana Wachowski"));
        movies.add(new Movie(orderIdGenerator.incrementAndGet(), "The Shawshank Redemption", 1994, "Frank Darabont"));
        movies.add(new Movie(orderIdGenerator.incrementAndGet(), "The Godfather", 1972, "Francis Ford Coppola"));
        movies.add(new Movie(orderIdGenerator.incrementAndGet(), "Pulp Fiction", 1994, "Quentin Tarantino"));
        return movies;
    }

    @Override
    public Movie findById(long id) {
        if(movies.size()>= id && id > 0)
            return movies.get((int)id-1);
        else
            return null;
    }

    @Override
    public Movie findByTitle(String title){
        for(Movie movie: movies){
            if(movie.getTitle().equalsIgnoreCase(title))
                return movie;
        }
        return null;
    }

    @Override
    public boolean addNew(Movie newMovie) {

        if(movies.contains(newMovie))
            return false;
        newMovie.setId(orderIdGenerator.incrementAndGet());
        movies.add(newMovie);
        return true;
    }

    @Override
    public List<String> listAllFiles() {
        List<String> moviesList=new ArrayList<String>();
        for(Movie movie:movies){
            moviesList.add("ID:"+movie.getId()+ ", Title:"+movie.getTitle());
        }
        return moviesList;
    }
}
