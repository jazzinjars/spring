package com.jazzinjars.spring.security.oauth.model;

import lombok.Data;

@Data
public class UserDto {

	private String username;
	private String password;
	private int age;
	private int salary;
}
