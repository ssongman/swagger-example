package com.ssongman.resource.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssongman.resource.model.User;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/rest/user")
@Api(value="user Resource REST Endpoint", description = "shows the user info")
public class user {

	@GetMapping
	public List<User> getUsers() {		
		return Arrays.asList(
				new User("song", 1000L),
				new User("kim", 1000L)
				);
	}
	
	@GetMapping("/{userName}")
	public User getUsers(@PathVariable("userName") final String userName) {
		return new User(userName, 1000L);
	}
	
	@PostMapping
	public User addUser(@RequestBody final User user) {
		return new User(user.getUserName(), user.getSalary());
	}
	

}
