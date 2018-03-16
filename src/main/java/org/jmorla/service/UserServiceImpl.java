package org.jmorla.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.jmorla.common.exception.ResourceNotFoundException;
import org.jmorla.domain.User;
import org.jmorla.repository.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

	private UserRepository userRepository;
	
	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	@Override
	public User saveUser(User u) {
		return userRepository.save(u);
	}

	@Override
	public User updateUser(final User u) {
		Optional<User> currentUser = userRepository.findById(u.getId());
		
		currentUser.ifPresent(e->{
			e.setName(u.getName());
			e.setEmail(u.getEmail());
			e.setAddress(u.getAddress());
			
			userRepository.save(e);
		});	
		
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
		Optional<User> user = userRepository.findByName(name);
		
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
