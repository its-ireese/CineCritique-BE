package com.techwright.cinecritique.repository;

import com.techwright.cinecritique.pojo.Movies;
import com.techwright.cinecritique.pojo.Reviews;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ReviewRepo extends MongoRepository<Reviews, ObjectId> {

    List<Optional<Reviews>> findReviewByImdbId(String imdbId);
    Optional<Reviews> getReviews(String imdbId);
}
