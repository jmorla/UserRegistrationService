package com.gallerin.service;

import java.util.Map;
import java.util.Optional;

import com.gallerin.domain.Hen;
import com.gallerin.domain.Rooster;

public interface BirdService {

	Map<String, Object> findBirdByOwner(int page, int size);
	
	Rooster addRooster(Rooster r);
	
	Rooster updateRooster(Rooster r, String roosterId);
	
	Rooster deleteRooster(String roosterId);
	
	Hen addHen(Hen h);
	
	Hen updateHen(Hen h, String henId);
	
	Hen deleteHen(String henId);
	
	Map<String, Integer> last12BirthsOfRoostersGroupedByMonth();
	
	Map<String, Integer> last12BirthsOfHenGroupedByMonth();
}
