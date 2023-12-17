package com.userservice.userservice.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.userservice.userservice.entities.User;
import com.userservice.userservice.exception.ResourceNotFoundException;
import com.userservice.userservice.repositories.UserRepo;
import com.userservice.userservice.services.UserService;

@Service
public class UserServiceImpl implements UserService {

   @Autowired
   private UserRepo userRepo;

   @Override
   public User saveUser(User user) {
      return this.userRepo.save(user);
   }

   @Override
   public List<User> getAllUser() {
      return this.userRepo.findAll();
   }

   @Override
   public User getUser(String userId) {

      return this.userRepo.findById(userId).orElse(() -> new ResourceNotFoundException("User not found", userId));

   }

}
