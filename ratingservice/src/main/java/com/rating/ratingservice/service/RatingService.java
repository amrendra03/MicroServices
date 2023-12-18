package com.rating.ratingservice.service;

import java.util.List;

import com.rating.ratingservice.entities.Rating;

public interface RatingService {

   // create
   Rating create(Rating rating);

   // get all rating
   List<Rating> getRating();

   // get all y userID
   List<Rating> getRatingByUserId(String userId);

   // get all by hotel
   List<Rating> getRatingByHotelId(String hotelId);

}
