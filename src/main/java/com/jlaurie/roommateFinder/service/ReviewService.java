package com.jlaurie.roommateFinder.service;

import com.jlaurie.roommateFinder.entity.Review;

import java.util.List;

public interface ReviewService {

    public List<Review> findAll();
    public Review getById(int review_id);
    public void save(Review review);
    public void update(Review review);
    public void deleteById(int review_id);

}
