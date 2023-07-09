package com.techwright.cinecritique.repository;

import com.techwright.cinecritique.pojo.Movies;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MoviesRepo extends MongoRepository<Movies, ObjectId> {
    Optional<Movies> findMovieByImdbId(String imdbId);
}
