package com.gallerin.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.gallerin.domain.Bird;
import com.gallerin.domain.Hen;
import com.gallerin.domain.Rooster;
import com.gallerin.domain.User;
import com.gallerin.repository.BirdRepository;
import com.gallerin.repository.UserRepository;
import com.gallerin.util.StringGenerator;

@Service
public class BirdServiceImpl implements BirdService {

	
	private BirdRepository birdRepository;
	private UserRepository userRepository;
	
	public BirdServiceImpl(BirdRepository birdRepository, UserRepository userRepository) {
		this.birdRepository = birdRepository;
		this.userRepository = userRepository;
	}

	@Override
	public Map<String, Object> findAllBirdsByUser(String username, int page, int size) {
		List<Bird> data = birdRepository.findAllBirdByUserOwner(username, page, size);
		
		Map<String, Object> map = new HashMap<>();
		map.put("data", data);
//		map.put("totalPages", data.getTotalPages());
//		map.put("totalElements", data.getTotalElements());
		
//		if(pag.getTotalPages() > (page+1)) {
//			map.put("nextPage", (page+1));
//		}
		
		return map;
	}

	@Override
	public Rooster addRooster(String username, Rooster rooster) {
		
		Optional<User> value = userRepository.findByUsername(username);
		if(value.isPresent()) {
			rooster.setBirdId(StringGenerator.generateBirdId());
			rooster.setUser(value.get());
			birdRepository.save(rooster);
		}
		
		return rooster;
	}

	@Override
	public Hen addHen(String username, Hen hen) {
		
		Optional<User> value = userRepository.findByUsername(username);
		if(value.isPresent()) {
			hen.setUser(value.get());
			birdRepository.save(hen);
		}
		
		return hen;
	}

	@Override
	public Bird deleteBird(String id) {
		
		return null;
//		return birdRepository.deleteBird(id);
	}

}
