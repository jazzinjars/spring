package com.jazzinjars.spring.bootjersey.rest.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@Data
public class User {

	private Integer userId;

	@NotNull
	private String firstName;

	@NotNull
	private String lastName;

	@NotNull
	private String companyName;

	public User() {}

	public User(Integer userId, String firstName, String lastName, String companyName) {
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.companyName = companyName;
	}
}
