package com.gallerin.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.gallerin.common.exception.DuplicateResourceException;
import com.gallerin.domain.User;
import com.gallerin.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	private UserRepository userRepository;
	
	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	@Override
	public User saveUser(User u) {
		
		Optional<User> user = userRepository.findByUsername(u.getUsername());
		if(user.isPresent()) {
			throw new DuplicateResourceException("this resource already exist, username="+u.getUsername());
		}
		return userRepository.save(u);
	}

	@Override
	public User updateUser(Long id, final User u) {
		Optional<User> currentUser = userRepository.findById(id);
		
		currentUser.ifPresent(e->{
			e.setEmail(u.getEmail());
			e.setAddress(u.getAddress());
			e.setFirstname(u.getFirstname());
			e.setLastname(u.getLastname());
			e.setAboutMe(u.getAboutMe());
			e.setCity(u.getCountry());
			e.setCountry(u.getCountry());
			e.setPostalCode(u.getPostalCode());
			
			userRepository.save(e);
		});	
		
		u.setId(id);
		
		return u;
	}

	@Override
	public void deleteUser(Long id) {
		userRepository.deleteById(id);
	}

	@Override
	public Optional<User> findUserById(Long id){
		Optional<User> user = userRepository.findById(id);
		
		return user;
	}
	
	@Override
	public Optional<User> findUserByName(String name) {
		Optional<User> user = userRepository.findByUsername(name);
		
		return user;
	}

	@Override
	public Map<String, Object> findAll(int p, int s) {
		Map<String, Object> map = new HashMap<>();
		
		Page<User> page = userRepository.findAll(PageRequest.of(p, s));
		map.put("data", page.getContent());
		map.put("totalPages", page.getTotalPages());
		map.put("totalElements", page.getTotalElements());
		
		if(page.getTotalPages() > (p+1)) {
			map.put("nextPage", (p+1));
		}
		
		return map;
	}

}
