package com.jazzinjars.spring.security.oauth.service;

import com.jazzinjars.spring.security.oauth.model.User;
import com.jazzinjars.spring.security.oauth.model.UserDto;

import java.util.List;

public interface UserService {

	User save(UserDto userDto);
	List<User> findAll();
	void delete(long id);
	User findOne(String username);
	User findById(long id);
}
