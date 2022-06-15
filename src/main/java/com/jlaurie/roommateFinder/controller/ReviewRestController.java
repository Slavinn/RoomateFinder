package com.jlaurie.roommateFinder.controller;


import com.jlaurie.roommateFinder.entity.Review;
import com.jlaurie.roommateFinder.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ReviewRestController {

    private ReviewService reviewService;

    @Autowired
    public ReviewRestController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping("/reviews")
    public List<Review> getReviews() {
        return reviewService.findAll();
    }

    @GetMapping("/reviews/{review_id}")
    public Review getReview(@PathVariable int review_id) {
        Review theReview = reviewService.getById(review_id);

        if (theReview == null) {
            throw new RuntimeException("Review ID not found - " + review_id);
        }
        return theReview;
    }

    @PostMapping("/reviews")
    public String saveReview(@RequestBody Review theReview,@RequestParam int id) {

        reviewService.save(theReview);

        return "Review added";
    }

    @PutMapping("/reviews")
    public String updateReview(@RequestBody Review theReview) {
        Review tempReview = reviewService.getById(theReview.getId());

        if (tempReview == null) {
            throw new RuntimeException("Review does not exist");
        }

        reviewService.update(tempReview);

        return "Review updated";
    }

    @DeleteMapping("/reviews/{review_id}")
    public String deleteReview(@PathVariable int review_id) {
        Review theReview = reviewService.getById(review_id);

        if (theReview == null) {
            throw new RuntimeException("Review ID not found - " + review_id);
        }
        reviewService.deleteById(review_id);

        return "Deleted Review";
    }
}
