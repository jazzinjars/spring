package com.jazzinjars.spring.bootjersey.client;

import com.jazzinjars.spring.bootjersey.rest.model.User;

public class ClientDataConstants {

	public static String USER_URI = "http://localhost:8080/users";

	public static User createDummyUser() {
		return new User(1, "John", "Snow", "Stark Enterprise");
	}
}
