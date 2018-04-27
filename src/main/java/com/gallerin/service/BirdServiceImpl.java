package com.gallerin.service;

import java.util.Map;
import java.util.Optional;

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

	
	private BirdRepository birdPrepository;
	private UserRepository userRepository;
	
	public BirdServiceImpl(BirdRepository birdRepository, UserRepository userRepository) {
		this.birdPrepository = birdRepository;
		this.userRepository = userRepository;
	}

	@Override
	public Map<String, Object> findAllBirdsByUser(String username, int page, int size) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Rooster addRooster(String username, Rooster rooster) {
		
		Optional<User> value = userRepository.findByUsername(username);
		if(value.isPresent()) {
			rooster.setBirdId(StringGenerator.generateBirdId());
			rooster.setUser(value.get());
			birdPrepository.save(rooster);
		}
		
		return rooster;
	}

	@Override
	public Hen addHen(String username, Hen hen) {
		
		Optional<User> value = userRepository.findByUsername(username);
		if(value.isPresent()) {
			hen.setUser(value.get());
			birdPrepository.save(hen);
		}
		
		return hen;
	}

	@Override
	public Bird deleteBird(long id) {
		
		return null;
	}

}
