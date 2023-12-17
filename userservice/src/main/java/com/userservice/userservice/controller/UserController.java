package com.userservice.userservice.controller;

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
   @GetMapping("/{userId}")
   public ResponseEntity<User> getUser(@PathVariable String userId) {
      User user = userService.getUser(userId);
      return new ResponseEntity<>(user, HttpStatus.OK);
   }

   // all user get
   @GetMapping("/")
   public ResponseEntity<List<User>> getAllUser() {

      List<User> allUser = userService.getAllUser();

      return new ResponseEntity<>(allUser, HttpStatus.OK);

   }

   // all user get

}
