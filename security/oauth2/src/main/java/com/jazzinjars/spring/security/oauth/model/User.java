package com.jazzinjars.spring.security.oauth.model;

import lombok.Data;
import org.codehaus.jackson.annotate.JsonIgnore;

import javax.persistence.*;

@Entity
@Data
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column
	private String username;

	@Column
	@JsonIgnore
	private String password;

	@Column
	private long salary;

	@Column
	private int age;
}
