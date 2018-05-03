package com.krzyszczak.allegroMovies.controler;

import com.krzyszczak.allegroMovies.model.Movie;
import com.krzyszczak.allegroMovies.service.*;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
@RequestMapping("/api")
public class MovieRestApiControler {

    MovieServiceInt movieServiceInt= new MovieServiceImp();

    @GetMapping("/movie")
    public List<Movie> listAllMovies() {
        return movieServiceInt.findAll();
    }

    @GetMapping("/movie/{id}")
    public Movie selectMovieById(@PathVariable("id") long id){
        return movieServiceInt.findById(id);
    }

    @GetMapping("/movie/{title}")
    public Movie selectMovieByName(@PathVariable("title") String title){
        return movieServiceInt.findByTitle(title);
    }


}
