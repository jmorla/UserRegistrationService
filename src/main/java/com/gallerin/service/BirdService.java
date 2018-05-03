package com.gallerin.service;

import java.util.Map;

import com.gallerin.common.pojo.BirdDetails;
import com.gallerin.domain.Bird;
import com.gallerin.domain.Hen;
import com.gallerin.domain.Rooster;

public interface BirdService {
	
	Map<String, Object> findAllBirdsByUser(String username, int page, int size);
	
	Rooster addRooster(String username, Rooster rooster);
	
	Hen addHen(String username, Hen hen);
	
	Bird addBird(String username, BirdDetails bird);
	
	Bird deleteBird(String id);
}
