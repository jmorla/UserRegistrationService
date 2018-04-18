package com.gallerin.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.context.SecurityContextHolder;

import com.gallerin.domain.Hen;
import com.gallerin.domain.Rooster;
import com.gallerin.repository.HenRepository;
import com.gallerin.repository.RoosterRepository;

public class BirdServiceImpl implements BirdService {

	private RoosterRepository roosterRepo;
	private HenRepository henRepo;
	
	@Override
	public Map<String, Object> findBirdByOwner(int page, int size) {
		Page<Rooster> roosterPage = roosterRepo.findRoosterByUserOwnerName
				(getLoggedUser(),PageRequest.of((page/2), size));
		
		Page<Hen> henPage = henRepo.findHenByUserOwnerName
				(getLoggedUser(), PageRequest.of((page/2), size));
		
		Map<String, Object> result = new HashMap();
		result.put("data", new Birds(roosterPage.getContent(),henPage.getContent()));

		result.put("next_page", page+1);
		
		return result;
	}

	@Override
	public Rooster addRooster(Rooster r) {
		Optional.ofNullable(r)
		.ifPresent(roosterRepo::save);
		
		return r;
	}

	@Override
	public Rooster updateRooster(Rooster r, String roosterId) {
		Optional<Rooster> rooster = roosterRepo.findRoosterById(getLoggedUser(), roosterId);
		if(rooster.isPresent()) {
			Rooster toUpdate = rooster.get();
			toUpdate.setBirth(r.getBirth());
			toUpdate.setAlias(r.getAlias());
			toUpdate.setPlate(r.getPlate());
			toUpdate.setScrath(r.getScrath());
			toUpdate.setDied(r.getDied());
			toUpdate.setStatus(r.getStatus());
			toUpdate.setEnrace(r.getEnrace());
			toUpdate.setComment(r.getComment());
			toUpdate.setColor(r.getColor());
			toUpdate.setCrest(r.getCrest());
			toUpdate.setPlateType(r.getPlateType());
		}
		return r;
	}

	@Override
	public Rooster deleteRooster(String roosterId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Hen addHen(Hen h) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Hen updateHen(Hen h, String henId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Hen deleteHen(String henId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Integer> last12BirthsOfRoostersGroupedByMonth() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Integer> last12BirthsOfHenGroupedByMonth() {
		// TODO Auto-generated method stub
		return null;
	}

	private String getLoggedUser() {
		return SecurityContextHolder.getContext()
				.getAuthentication()
				.getName();
	}
	
	public static class Birds{
	
		private final List<Rooster> roosters;
		private final List<Hen> hen;
		
		public Birds(List<Rooster> roosters, List<Hen> hen) {
			this.roosters = roosters;
			this.hen = hen;
		}

		public List<Rooster> getRoosters() {
			return roosters;
		}

		public List<Hen> getHen() {
			return hen;
		}
	}

}
