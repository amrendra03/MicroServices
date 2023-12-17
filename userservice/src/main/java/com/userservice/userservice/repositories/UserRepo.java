package com.userservice.userservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.userservice.userservice.entities.User;

public interface UserRepo extends JpaRepository<User, String> {

}