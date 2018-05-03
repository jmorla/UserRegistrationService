package com.gallerin.controller;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gallerin.common.pojo.BirdDetails;
import com.gallerin.domain.Bird;
import com.gallerin.domain.Hen;
import com.gallerin.domain.Rooster;
import com.gallerin.service.BirdService;

@Controller
@RequestMapping("/birds")
public class BirdController {

	@Autowired
	private BirdService birdService;

	@GetMapping(produces=MediaType.APPLICATION_JSON_UTF8_VALUE, params = {"page","size"})
	public ResponseEntity<Map<String, Object>> birdsByUserOwner(@RequestParam("page") int page,
												@RequestParam("size") int size){
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
		Map<String,Object> response = birdService.findAllBirdsByUser(auth.getName(), page, size);
		if(response==null || ((List<?>)response.get("data")).isEmpty()) {
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
	
	@PostMapping(produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Bird> addBird(@RequestBody BirdDetails bird)
	{
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();	
		Bird b = birdService.addBird(auth.getName(), bird);
		return new ResponseEntity<Bird>(b, HttpStatus.CREATED);
	}
}
