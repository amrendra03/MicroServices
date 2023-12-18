package com.rating.ratingservice.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rating.ratingservice.entities.Rating;

public interface RatingRepo extends JpaRepository<Rating, String> {

   // custom method query
   List<Rating> findByUserId(String userId);

   List<Rating> findByHotelId(String hotelId);

}