package com.jazzinjars.spring.bootjersey.exception;

import javax.ws.rs.NotFoundException;
import javax.ws.rs.core.Response;

import static java.util.Collections.singletonMap;

public class UserNotFoundException extends NotFoundException {

	private static final long seriaVersionUID = 3873418545077760440L;

	public UserNotFoundException(String message) {
		super(Response.status(Response.Status.NOT_FOUND).entity(singletonMap("error", message)).build());
	}
}
