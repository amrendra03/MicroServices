package com.userservice.userservice.services;

import java.util.List;

import com.userservice.userservice.entities.User;

public interface UserService {

   User saveUser(User user);

   List<User> getAllUser();

   User getUser(String userId);

}
