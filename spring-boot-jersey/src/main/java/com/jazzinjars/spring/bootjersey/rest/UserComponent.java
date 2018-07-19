package com.jazzinjars.spring.bootjersey.rest;

import com.jazzinjars.spring.bootjersey.exception.UserNotFoundException;
import com.jazzinjars.spring.bootjersey.rest.model.User;
import com.jazzinjars.spring.bootjersey.rest.resource.UserResource;
import com.jazzinjars.spring.bootjersey.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import javax.validation.Valid;
import javax.ws.rs.Path;
import java.util.List;

@Path("/users")
public class UserComponent implements UserResource {

	@Autowired
	private UserService userService;

	@Override
	public List<User> getUsers(String companyName) {
		return userService.searchByCompanyName(companyName);
	}

	@Override
	public User findUserById(int userId) {
		User found = userService.findById(userId);
		if (null == found) {
			throw new UserNotFoundException("Invalid userID: " + userId);
		}
		return found;
	}

	@Override
	public User createUser(@Valid User request) {
		User saved = userService.save(request);
		return saved;
	}

	@Override
	public User updateUser(Integer userId, @Valid User request) {
		User found = userService.findById(userId);
		if (null == found) {
			throw new UserNotFoundException("Invalid userID: " + userId);
		}
		if (!StringUtils.isEmpty(request.getCompanyName())) {
			found.setCompanyName(request.getCompanyName());
		}
		if (!StringUtils.isEmpty(request.getFirstName())) {
			found.setFirstName(request.getFirstName());
		}
		if (!StringUtils.isEmpty(request.getLastName())) {
			found.setLastName(request.getLastName());
		}
		return userService.save(found);
	}

	@Override
	public void deleteUser(Integer userId) {
		User found = userService.findById(userId);
		if (null == found) {
			throw new UserNotFoundException("Invalid userID: " + userId);
		}
		userService.deleteById(userId);
	}
}
