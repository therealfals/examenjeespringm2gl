package com.examenjava.isi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.examenjava.isi.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	 @Query("SELECT u FROM User u WHERE u.email=:email ")
	    User findByEmail(String email);
}