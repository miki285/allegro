package com.krzyszczak.allegroMovies.controler;

import com.krzyszczak.allegroMovies.model.Movie;
import com.krzyszczak.allegroMovies.service.MovieService;
import com.krzyszczak.allegroMovies.utils.CustomMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@RestController
@RequestMapping("/api")
public class MovieRestApiControler {
    @Autowired
    private MovieService movieService;

    // GET list of movies
    @GetMapping("/movie")
    public ResponseEntity<?> listAllMovies() {
        List<String> moviesList= movieService.listAllFiles();
        if(moviesList.isEmpty())
            return new ResponseEntity<>(new CustomMessage("No movies in database."),
                    HttpStatus.NOT_FOUND);
        else
            return new ResponseEntity<>(movieService.listAllFiles(),
                HttpStatus.OK);
    }
    //GET details about movie[id]
    @GetMapping("/movie/{id}")
    public ResponseEntity<?> selectMovieById(@PathVariable("id") long id){
        Movie movie= movieService.findById(id);
        if(movie==null)
            return new ResponseEntity<>(new CustomMessage("Selected movie not found."),
                    HttpStatus.NOT_FOUND);
        else
            return new ResponseEntity<>(movie, HttpStatus.OK);
    }
    //POST new movie
    @PostMapping("/movie")
    public ResponseEntity<?> addMovie(@RequestBody Movie movie) {
        if (movieService.addNew(movie)) {
            return new ResponseEntity<>(new CustomMessage("New movie added successfully"), HttpStatus.OK);
        } else
            return new ResponseEntity<>(new CustomMessage("Selected movie exists"),
                    HttpStatus.CONFLICT);

    }
}
