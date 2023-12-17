package com.userservice.userservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.userservice.userservice.entities.User;
import com.userservice.userservice.services.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

   @Autowired
   private UserService userService;

   // create
   @PostMapping("/")
   public ResponseEntity<User> createUser(@RequestBody User user) {

      User user2 = this.userService.saveUser(user);

      return new ResponseEntity<>(user2, HttpStatus.CREATED);
   }

   // single user get

   // all user get

}
