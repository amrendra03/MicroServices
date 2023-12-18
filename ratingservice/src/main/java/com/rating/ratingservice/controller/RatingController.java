package com.rating.ratingservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rating.ratingservice.entities.Rating;
import com.rating.ratingservice.service.RatingService;

@RestController
@RequestMapping("/ratings")
public class RatingController {

   @Autowired
   private RatingService ratingService;

   // create rating
   @PostMapping("/")
   public ResponseEntity<Rating> create(@RequestBody Rating rating) {

      return new ResponseEntity<>(this.ratingService.create(rating), HttpStatus.CREATED);
   }

   // get all rating
   @GetMapping("/")
   public ResponseEntity<List<Rating>> getRatings() {
      return new ResponseEntity<>(this.ratingService.getRating(), HttpStatus.OK);
   }

   // get all rating by userId
   @GetMapping("/users/{userId}")
   public ResponseEntity<List<Rating>> getBYUserId(@PathVariable String userId) {
      return new ResponseEntity<>(this.ratingService.getRatingByUserId(userId), HttpStatus.OK);
   }

   // get all rating by hotelId
   @GetMapping("/hotels/{hotelId}")
   public ResponseEntity<List<Rating>> getByHotelId(@PathVariable String hotelId) {
      return new ResponseEntity<>(this.ratingService.getRatingByHotelId(hotelId), HttpStatus.OK);
   }

}
