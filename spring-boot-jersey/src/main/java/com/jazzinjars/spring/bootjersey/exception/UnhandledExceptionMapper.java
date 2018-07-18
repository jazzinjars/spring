package com.jazzinjars.spring.bootjersey.exception;

import org.glassfish.jersey.spi.ExtendedExceptionMapper;

import static java.util.Collections.singletonMap;
import static javax.ws.rs.core.Response.Status.INTERNAL_SERVER_ERROR;

import javax.ws.rs.InternalServerErrorException;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import java.util.LinkedList;
import java.util.List;

public class UnhandledExceptionMapper implements ExtendedExceptionMapper<Exception> {

	private List<Class<? extends Exception>> filteredExceptions = new LinkedList<Class<? extends Exception>>();

	/**
	 * All REST services should catch Exceptions and repackage them as WebApplicationExcetion or more specific subclasses
	 * @param e the Exception to be encapsulated
	 * @return Wrapped Exception
	 */
	@Override
	public boolean isMappable(Exception e) {
		for (Class<? extends Exception> filteredException : filteredExceptions) {
			if (filteredException.isAssignableFrom(e.getClass())) {
				return false;
			}
		}
		return true;
	}

	@Override
	public Response toResponse(Exception e) {

		if (e instanceof WebApplicationException) {
			if (e instanceof InternalServerErrorException) {
				return Response.status(INTERNAL_SERVER_ERROR).entity(singletonMap("error", "UNEXPECTED_ERROR")).build();
			}
			final WebApplicationException exception = (WebApplicationException) e;
			return exception.getResponse();
		}

		return Response.status(INTERNAL_SERVER_ERROR).entity(singletonMap("error", "UNEXPECTED_ERROR" + buildErrorMessage(e))).build();
	}

	private String buildErrorMessage(Exception exception) {
		return exception.getClass().getSimpleName() + ": " + exception.getMessage();
	}
}
