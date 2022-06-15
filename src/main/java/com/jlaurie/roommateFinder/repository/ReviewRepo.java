package com.jlaurie.roommateFinder.repository;

import com.jlaurie.roommateFinder.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepo extends JpaRepository<Review, Integer> {
}
