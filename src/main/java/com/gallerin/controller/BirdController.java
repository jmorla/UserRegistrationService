package com.gallerin.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
		
		Map<String,Object> response = birdService.findAllBirdsByUser(auth.getName(), 0, 10);
		if(response==null || ((List<?>)response.get("data")).isEmpty()) {
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
}
