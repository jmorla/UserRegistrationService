package org.jmorla.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.jmorla.common.exception.ResourceNotFoundException;
import org.jmorla.domain.User;
import org.jmorla.service.UserService;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserRegistrationController {

	private UserService userService;
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	public UserRegistrationController(UserService userService, BCryptPasswordEncoder bCryptPasswordEncoder) {
		this.userService = userService;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}

	@GetMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE, params = { "page", "size" })
	public ResponseEntity<Map<String, Object>> listAllUsers(@RequestParam(value = "page") int page,
			@RequestParam(value = "size") int size) {

		Map<String, Object> response = userService.findAll(page, size);
		if(((List)response.get("data")).isEmpty()) {
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}

	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<User> getUserById(@PathVariable("id") Long id) {
		Optional<User> user = userService.findUserById(id);
		user.orElseThrow(()->{
			return new ResourceNotFoundException("User", "[ id ]");
		});
		
		return new ResponseEntity<User>(user.get(), HttpStatus.OK);

	}

	@GetMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE, params = { "name" })
	public ResponseEntity<User> getUserByName(String name) {
		Optional<User> user = userService.findUserByName(name);
		user.orElseThrow(()->{
			return new ResourceNotFoundException("User", "[ name ]");
		});

		return new ResponseEntity<User>(user.get(), HttpStatus.OK);
	}

	@PostMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<User> createUser(@RequestBody @Valid final User user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		userService.saveUser(user);
		return new ResponseEntity<User>(user, HttpStatus.CREATED);
	}
	
	@PutMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<User> updateUser(@RequestBody @Valid final User user,@PathVariable("id") Long id){
		userService.updateUser(id,user);
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<User> deleteUser(@PathVariable("id") Long id){
		
		userService.findUserById(id).ifPresent(e->{	
			throw new ResourceNotFoundException(e.getClass().getSimpleName(),"[ id ]");
		});
		userService.deleteUser(id);
		return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
	}

}
