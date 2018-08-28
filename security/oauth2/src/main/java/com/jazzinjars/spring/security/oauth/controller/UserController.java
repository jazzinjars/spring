package com.jazzinjars.spring.security.oauth.controller;

import com.jazzinjars.spring.security.oauth.model.User;
import com.jazzinjars.spring.security.oauth.model.UserDto;
import com.jazzinjars.spring.security.oauth.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public List<User> listUser() {
		return userService.findAll();
	}

	@RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
	public User getOne(@PathVariable(value = "id") Long id) {
		return userService.findById(id);
	}

	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public User saveUser(@RequestBody UserDto userDto) {
		return userService.save(userDto);
	}
}
