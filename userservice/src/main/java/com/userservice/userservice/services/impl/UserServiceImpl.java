package com.userservice.userservice.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

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

      ArrayList arr = restTemplate
            .getForObject("http://localhost:8083/ratings/users/12b688ac-7d4c-4ffd-ac54-799767829436", ArrayList.class);

      logger.info("{}", arr);
      return user;
   }

}
