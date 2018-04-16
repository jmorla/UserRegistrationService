package com.gallerin.service;

import java.util.Map;
import java.util.Optional;

import com.gallerin.domain.User;

public interface UserService {

	User saveUser(User u);
	
	User updateUser(Long id, User u);
	
	void deleteUser(Long id);
	
	Optional<User> findUserById(Long id);
	
	Optional<User> findUserByName(String name);
	
	Map<String,Object> findAll(int p, int s);
}
