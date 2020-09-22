package com.nnk.springboot.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nnk.springboot.domain.Rating;
import com.nnk.springboot.repositories.RatingRepository;

@Service
public class RatingService {

	@Autowired
    private RatingRepository ratingRepository;
	
	public Rating getRating(Integer id) {
		
		return ratingRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid rating Id:" + id));
	}
	
	
	public List<Rating> getAllRatings() {
		
		return ratingRepository.findAll();
	}
	
	
	public void saveRating(Rating rating) {
		
		ratingRepository.save(rating);
	}
	
	public void deleteRating(Integer id) {
		
		Rating rating = ratingRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid rating Id:" + id));
		ratingRepository.delete(rating);
	}
}
