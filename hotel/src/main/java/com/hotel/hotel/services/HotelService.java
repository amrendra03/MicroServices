package com.hotel.hotel.services;

import java.util.List;

import com.hotel.hotel.entities.Hotel;

public interface HotelService {

   // create
   Hotel save(Hotel hotel);

   // get all
   List<Hotel> getAll();

   // get single
   Hotel getSingle(String id);

}
