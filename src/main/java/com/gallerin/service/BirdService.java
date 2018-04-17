package com.gallerin.service;

import java.util.Map;

import com.gallerin.domain.Bird;

public interface BirdService {

	Map<String, Object> findBirdByOwnerName(String owerName, int page, int size);
	
	Bird addBird(Bird bird);
	
	Bird updateBird(Bird bird);
	
	Bird removeBird(Bird bird);
}
