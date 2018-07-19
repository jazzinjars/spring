package com.jazzinjars.spring.bootjersey.service;

import com.jazzinjars.spring.bootjersey.entity.Person;
import com.jazzinjars.spring.bootjersey.mapper.UserConverter;
import com.jazzinjars.spring.bootjersey.repository.PersonRepository;
import com.jazzinjars.spring.bootjersey.rest.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
@Transactional
public class UserService implements CRUDService<User> {

	@Autowired
	private PersonRepository personRepository;

	@Autowired
	private UserConverter converter;

	@Override
	public User save(User user) {
		Person saved = personRepository.save(converter.convertFromDto(user));
		return converter.convertFromEntity(saved);
	}

	@Override
	public User findById(Integer identifier) {
		if (identifier.intValue() < 0) {
			throw new RuntimeException("Caught unhandle runtime");
		}
		Person found = personRepository.findUser(identifier);
		if (found != null) {
			return converter.convertFromEntity(found);
		}
		return null;
	}

	@Override
	public List<User> searchByCompanyName(String companyName) {
		List<Person> persons = personRepository.findByCompany(companyName);
		List<User> users = new ArrayList<>();

		for (Person person : persons) {
			users.add(converter.convertFromEntity(person));
		}
		return users;
	}

	@Override
	public void deleteById(Integer identifier) {
		personRepository.deleteById(identifier);
	}
}
