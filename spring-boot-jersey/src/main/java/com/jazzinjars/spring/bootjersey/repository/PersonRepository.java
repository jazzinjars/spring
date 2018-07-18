package com.jazzinjars.spring.bootjersey.repository;

import com.jazzinjars.spring.bootjersey.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PersonRepository extends JpaRepository<Person, Integer> {

	@Query("SELECT person FROM Person person WHERE person.companyName = : companyName")
	List<Person> findByCompany(@Param("companyName") String companyName);
}
