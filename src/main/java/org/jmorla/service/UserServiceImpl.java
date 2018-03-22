package org.jmorla.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.jmorla.common.exception.DuplicateResourceException;
import org.jmorla.domain.User;
import org.jmorla.repository.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

	private UserRepository userRepository;
	
	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	@Override
	public User saveUser(User u) {
		
		Optional<User> user = userRepository.findByUsername(u.getFirstname());
		if(user.isPresent()) {
			throw new DuplicateResourceException("this resource already exist");
		}
		return userRepository.save(u);
	}

	@Override
	public User updateUser(Long id, final User u) {
		Optional<User> currentUser = userRepository.findById(id);
		
		currentUser.ifPresent(e->{
			e.setUsername(u.getUsername());
			e.setEmail(u.getEmail());
			e.setAddress(u.getAddress());
			e.setFirstname(u.getFirstname());
			e.setLastname(u.getLastname());
			
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
		map.put("total_pages", page.getTotalPages());
		map.put("total_elements", page.getTotalElements());
		
		if(page.getTotalPages() > (p+1)) {
			map.put("next_page", (p+1));
		}
		
		return map;
	}

}
