package com.rating.ratingservice.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rating.ratingservice.entities.Rating;
import com.rating.ratingservice.repositories.RatingRepo;
import com.rating.ratingservice.service.RatingService;

@Service
public class RatingServiceImpl implements RatingService {

   @Autowired
   private RatingRepo ratingRepo;

   @Override
   public Rating create(Rating rating) {
      String randomUserId = UUID.randomUUID().toString();
      rating.setRatingId(randomUserId);

      return this.ratingRepo.save(rating);
   }

   @Override
   public List<Rating> getRating() {
      return this.ratingRepo.findAll();
   }

   @Override
   public List<Rating> getRatingByUserId(String userId) {
      return this.ratingRepo.findByUserId(userId);
   }

   @Override
   public List<Rating> getRatingByHotelId(String hotelId) {
      return this.ratingRepo.findByHotelId(hotelId);
   }

}
