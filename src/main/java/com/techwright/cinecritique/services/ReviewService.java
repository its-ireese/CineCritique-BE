package com.techwright.cinecritique.services;

import com.techwright.cinecritique.pojo.Movies;
import com.techwright.cinecritique.pojo.Reviews;
//import com.techwright.cinecritique.repository.MoviesRepo;
import com.techwright.cinecritique.repository.ReviewRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ReviewService {
    @Autowired
    private ReviewRepo reviewRepo;

   /* @Autowired
    private MoviesRepo moviesRepo;*/

    @Autowired
    private MongoTemplate mongoTemplate;

    public Reviews createReview(String reviewBody, String imdbId){
        Reviews reviews = reviewRepo.insert(new Reviews(reviewBody, LocalDateTime.now(), LocalDateTime.now()));

       reviewRepo.insert(reviews);
        mongoTemplate.update(Movies.class).matching(Criteria.where("imdbId").is(imdbId))
                .apply(new Update().push("reviewIds").value(reviews)).first();

        return reviews;
    }

/*    public Reviews getMovieReview(String imdbId){
        Reviews movieReviews = (Reviews) reviewRepo.getReviews(imdbId);

        // reviewRepo.insert(reviews);
        mongoTemplate.find("reviews").matching(Criteria.where("imdbId").is(imdbId));

        return movieReviews;
    }*/
//    public Optional<Movies> findReviewsByImdbId(String imdbId){
//        return moviesRepo.findMovieByImdbId(imdbId);
//    }
 /*   public Reviews getReviews<Optional<Reviews>> findReviewsByImdbId(String imdbId){
        return reviewRepo.findReviewByImdbId(imdbId);
}*/

    public Optional<Reviews> getReviews(String imdbId){
        return reviewRepo.getReviews(imdbId);
    }
    public List<Optional<Reviews>> findReviewsByImdbId(String imdbId){
        return reviewRepo.findReviewByImdbId(imdbId);
    }
}
