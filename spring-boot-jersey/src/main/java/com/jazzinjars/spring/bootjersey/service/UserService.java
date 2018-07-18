package com.jazzinjars.spring.bootjersey.service;

import com.jazzinjars.spring.bootjersey.rest.model.User;

import java.util.List;

public interface UserService {

	User save(User user);

	User findById(Integer personId);

	List<User> searchByCompanyName(String companyName);

	void deleteById(Integer personId);
}
