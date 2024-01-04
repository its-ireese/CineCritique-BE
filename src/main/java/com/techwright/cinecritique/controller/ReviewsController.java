package com.techwright.cinecritique.controller;

import com.techwright.cinecritique.pojo.Reviews;
import com.techwright.cinecritique.services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/reviews")
//@RequestMapping("/{imdbId}/reviews")
//@RequestMapping("/reviews/{imdbId}")
public class ReviewsController {
    @Autowired
    private ReviewService reviewService;

    @PostMapping
    public ResponseEntity<Reviews> createReview(@RequestBody Map<String, String> payload){
        return new ResponseEntity<>(reviewService.createReview(payload.get("reviewBody"), payload.get("imdbId")), HttpStatus.CREATED);
    }

/*    @GetMapping("/Reviews/{imdbId}")
    public ResponseEntity<List<Reviews>> getReviews(@PathVariable String imdbId){
        return new ResponseEntity<List<Reviews>>((MultiValueMap<String, String>) reviewService.getReviews(imdbId), HttpStatus.OK);
    }*/

    @GetMapping("/{imdbId}/reviews")
    public ResponseEntity<List<Optional<Reviews>>> getMovieReviews(@PathVariable String imdbId){
        return new ResponseEntity<List<Optional<Reviews>>>(reviewService.findReviewsByImdbId(imdbId), HttpStatus.OK);
    }

}
