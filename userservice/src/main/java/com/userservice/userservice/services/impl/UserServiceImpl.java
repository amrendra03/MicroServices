package com.userservice.userservice.services.impl;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import com.userservice.userservice.external.services.HotelService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.userservice.userservice.entities.Hotel;
import com.userservice.userservice.entities.Rating;
import com.userservice.userservice.entities.User;
import com.userservice.userservice.exception.ResourceNotFoundException;
import com.userservice.userservice.repositories.UserRepo;
import com.userservice.userservice.services.UserService;

@Service
public class UserServiceImpl implements UserService {

   @Autowired
   private UserRepo userRepo;

   @Autowired
   private RestTemplate restTemplate;

   @Autowired
   private HotelService hotelService;

   private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

   @Override
   public User saveUser(User user) {
      String randomUserId = UUID.randomUUID().toString();
      user.setUserId(randomUserId);
      return this.userRepo.save(user);
   }

   @Override
   public List<User> getAllUser() {
      return this.userRepo.findAll();
   }

   @Override
   public User getUser(String userId) {

      User user = this.userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User not found"));

      Rating[] all = restTemplate.getForObject("http://localhost:8083/ratings/users/" + user.getUserId(),
            Rating[].class);

      List<Rating> list = Arrays.stream(all).toList();

      // logger.info("{}", arr);
      List<Rating> rat = list.stream().map(x -> {

//         ResponseEntity<Hotel> hotel = restTemplate.getForEntity("http://localhost:8082/hotels/" + x.getHotelId(),
//               Hotel.class);
         Hotel h = hotelService.getHOtel(x.getHotelId());
         x.setHotel(h);
         return x;
      }).collect(Collectors.toList());
      user.setRatings(rat);
      return user;
   }

}
