package org.gallerin.service;

import java.util.Map;
import java.util.Optional;

import org.gallerin.domain.User;

public interface UserService {

	User saveUser(User u);
	
	User updateUser(Long id, User u);
	
	void deleteUser(Long id);
	
	Optional<User> findUserById(Long id);
	
	Optional<User> findUserByName(String name);
	
	Map<String,Object> findAll(int p, int s);
}
