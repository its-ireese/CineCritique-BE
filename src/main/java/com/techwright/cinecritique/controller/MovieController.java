package com.techwright.cinecritique.controller;

import com.techwright.cinecritique.pojo.Movies;
import com.techwright.cinecritique.services.MoviesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/movies")
public class MovieController {
    @Autowired
    private MoviesService moviesService;

    @GetMapping
    public ResponseEntity<List<Movies>> allMovies(){
        return new ResponseEntity<List<Movies>>(moviesService.getAllMovies(), HttpStatus.OK);
    }

    @GetMapping("/{imdbId}")
    public ResponseEntity<Optional<Movies>> getMovie(@PathVariable String imdbId){
        return new ResponseEntity<Optional<Movies>>(moviesService.getMovie(imdbId), HttpStatus.OK);
    }
}
