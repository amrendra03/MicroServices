package com.userservice.userservice.external.services;

import com.userservice.userservice.entities.Rating;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "RATING-SERVICE")
public interface RatingService {

    //post
    @PostMapping("/ratings")
    public  Rating createRating(Rating values);




}
