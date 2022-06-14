package com.jlaurie.roommateFinder.service;

import com.jlaurie.roommateFinder.entity.Review;
import com.jlaurie.roommateFinder.repository.ReviewRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ReviewServiceImpl implements ReviewService{

    private ReviewRepo reviewRepo;

    @Autowired
    public ReviewServiceImpl(ReviewRepo reviewRepo) {
        this.reviewRepo = reviewRepo;
    }

    @Override
    public List<Review> findAll() {
        return reviewRepo.findAll();
    }

    @Override
    public Review getById(int review_id) {
        return reviewRepo.getReferenceById(review_id);
    }

    @Override
    public void save(Review review) {
        reviewRepo.save(review);
    }

    @Override
    public void update(Review review) {
        reviewRepo.save(review);
    }

    @Override
    public void deleteById(int review_id) {
        reviewRepo.deleteById(review_id);
    }
}
