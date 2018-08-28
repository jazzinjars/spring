package com.jazzinjars.spring.security.oauth.service.impl;

import com.jazzinjars.spring.security.oauth.dao.UserDao;
import com.jazzinjars.spring.security.oauth.model.User;
import com.jazzinjars.spring.security.oauth.model.UserDto;
import com.jazzinjars.spring.security.oauth.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service(value = "userService")
public class UserServiceImpl implements UserService, UserDetailsService {

	@Autowired
	private UserDao userDao;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userDao.findByUsername(username);

		if (user == null) {
			throw new UsernameNotFoundException("Invalid username or password");
		}
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), getAuthority());
	}

	@Override
	public User save(UserDto userDto) {
		User user = new User();
		user.setUsername(userDto.getUsername());
		user.setPassword(bCryptPasswordEncoder.encode(userDto.getPassword()));
		user.setAge(userDto.getAge());
		user.setSalary(userDto.getSalary());
		return userDao.save(user);
	}

	@Override
	public List<User> findAll() {
		List<User> users = new ArrayList<>();
		userDao.findAll().iterator().forEachRemaining(users::add);
		return users;
	}

	@Override
	public void delete(long id) {
		userDao.delete(id);
	}

	@Override
	public User findOne(String username) {
		return userDao.findByUsername(username);
	}

	@Override
	public User findById(long id) {
		return userDao.findOne(id);
	}

	private List<SimpleGrantedAuthority> getAuthority() {
		return Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"));
	}
}
