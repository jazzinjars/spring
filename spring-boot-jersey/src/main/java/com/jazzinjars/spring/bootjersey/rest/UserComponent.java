package com.jazzinjars.spring.springbootjersey.rest;

import com.jazzinjars.spring.springbootjersey.model.User;
import com.jazzinjars.spring.springbootjersey.rest.resource.UserResource;

import javax.validation.Valid;
import java.util.List;

public class UserComponent implements UserResource {

	@Override
	public List getUsers(String companyName) {
		return null;
	}

	@Override
	public User findUserById(int userId) {
		return null;
	}

	@Override
	public User createUser(@Valid User request) {
		return null;
	}

	@Override
	public User updateUser(Integer userId, @Valid User request) {
		return null;
	}

	@Override
	public void deleteUser(Integer userId) {

	}
}
