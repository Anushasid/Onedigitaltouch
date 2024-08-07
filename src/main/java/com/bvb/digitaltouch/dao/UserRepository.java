package com.bvb.digitaltouch.dao;

import java.util.Optional;



import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;


import com.bvb.digitaltouch.modules.User;


@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	
	//@Query("SELECT u FROM User_tbl u WHERE u.email=?1")
	Optional<User> findByEmail(String email);
	
}
