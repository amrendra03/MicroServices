package com.userservice.userservice.controller;

import java.util.List;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import org.apache.catalina.connector.Response;
import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

   private Logger logger = LoggerFactory.getLogger(UserController.class);


   // create
   @PostMapping("/")
   public ResponseEntity<User> createUser(@RequestBody User user) {

      User user2 = this.userService.saveUser(user);

      return new ResponseEntity<>(user2, HttpStatus.CREATED);
   }

   // single user get
   int retryCount=1;
   @GetMapping("/{userId}")
//   @CircuitBreaker(name="ratingHotelBreaker",fallbackMethod = "ratingHotelFallBack")
//   @Retry(name="ratingHotelService",fallbackMethod = "ratingHotelFallBack")
   @RateLimiter(name="userRateLimiter",fallbackMethod = "ratingHotelFallBack")
   public ResponseEntity<User> getUser(@PathVariable String userId) {
      logger.info("from User Service Controller:---");
      logger.info("Retry Count:{}",retryCount);
      retryCount++;
//      System.out.println(retryCount+" ------------------------m");
      System.out.println("checked...");
      User user = userService.getUser(userId);
      return new ResponseEntity<>(user, HttpStatus.OK);
   }

   // creating fall back method for circuitbreakerr


   public ResponseEntity<User> ratingHotelFallBack(String userId , Exception ex){
//      retryCount+=1;
     logger.info("FallBack is executed because service is down: ",ex.getMessage());
      User user = new User("1242","dummy@email.com","Servicess are down","Not  create",null);
      return new ResponseEntity<>(user,HttpStatus.OK);
   }


   // all user get
   @GetMapping("/")
   public ResponseEntity<List<User>> getAllUser() {

      List<User> allUser = userService.getAllUser();

      return new ResponseEntity<>(allUser, HttpStatus.OK);

   }

   // all user get

}
