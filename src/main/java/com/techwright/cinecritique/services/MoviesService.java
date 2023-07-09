package com.techwright.cinecritique.services;

import com.techwright.cinecritique.pojo.Movies;
import com.techwright.cinecritique.repository.MoviesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MoviesService {
    @Autowired
    private MoviesRepo moviesRepo;
    public List<Movies> getAllMovies(){
        return moviesRepo.findAll();
    }

    public Optional<Movies> getMovie(String imdbId){
        return moviesRepo.findMovieByImdbId(imdbId);
    }
}
