package com.hotel.hotel.controller;

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

import com.hotel.hotel.entities.Hotel;
import com.hotel.hotel.services.HotelService;

@RestController
@RequestMapping("/hotels")
public class HotelController {

   @Autowired
   private HotelService hotelService;

   // create
   @PostMapping("/")
   public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel) {
      Hotel hotel2 = this.hotelService.save(hotel);

      return new ResponseEntity<>(hotel2, HttpStatus.CREATED);
   }

   // get all
   @GetMapping("/")
   public ResponseEntity<List<Hotel>> getAll() {
      return new ResponseEntity<>(this.hotelService.getAll(), HttpStatus.OK);
   }

   // get single by id
   @GetMapping("/{hotelId}")
   public ResponseEntity<Hotel> get(@PathVariable String hotelId) {

      return new ResponseEntity<>(this.hotelService.getSingle(hotelId), HttpStatus.OK);
   }

}
