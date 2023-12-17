package com.hotel.hotel.services.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.hotel.entities.Hotel;
import com.hotel.hotel.exception.ResourceNotFoundException;
import com.hotel.hotel.repositories.HotelRepo;
import com.hotel.hotel.services.HotelService;

@Service
public class HotelServiceImpl implements HotelService {

   @Autowired
   private HotelRepo hotelRepo;

   @Override
   public Hotel save(Hotel hotel) {

      String id = UUID.randomUUID().toString();
      hotel.setId(id);
      Hotel hotel2 = this.hotelRepo.save(hotel);

      return hotel2;

   }

   @Override
   public List<Hotel> getAll() {
      List<Hotel> all = this.hotelRepo.findAll();

      return all;
   }

   @Override
   public Hotel getSingle(String id) {
      Hotel hotel = this.hotelRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Hotel not found"));

      return hotel;
   }

}
