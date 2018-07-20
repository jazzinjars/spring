package com.jazzinjars.spring.bootjersey.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int personId;

	private String fName;
	private String lName;
	private String companyName;
	private String mName;

	public Person() {}

	public Person(int personId, String fName, String lName, String companyName, String mName) {
		this.personId = personId;
		this.fName = fName;
		this.lName = lName;
		this.mName = mName;
	}
}
