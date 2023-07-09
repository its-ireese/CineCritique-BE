package com.techwright.cinecritique.services;

import com.techwright.cinecritique.pojo.Movies;
import com.techwright.cinecritique.pojo.Reviews;
import com.techwright.cinecritique.repository.ReviewRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {
    @Autowired
    private ReviewRepo reviewRepo;

    @Autowired
    private MongoTemplate mongoTemplate;

    public Reviews createReview(String reviewBody, String imdbId){
        Reviews reviews = reviewRepo.insert(new Reviews(reviewBody));

        reviewRepo.insert(reviews);
        mongoTemplate.update(Movies.class).matching(Criteria.where("imdbId").is(imdbId))
                .apply(new Update().push("reviewIds").value(reviews)).first();

        return reviews;
    }
}
