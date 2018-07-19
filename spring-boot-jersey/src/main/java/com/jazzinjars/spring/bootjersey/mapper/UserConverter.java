package com.jazzinjars.spring.bootjersey.mapper;

import com.jazzinjars.spring.bootjersey.entity.Person;
import com.jazzinjars.spring.bootjersey.rest.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserConverter extends Converter<User, Person> {

	public UserConverter() {
		super(user -> new Person(user.getUserId(), user.getFirstName(), user.getLastName(), user.getCompanyName(), ""),
			 person -> new User(person.getPersonId(), person.getFName(), person.getLName(), person.getCompanyName()));
	}
}
