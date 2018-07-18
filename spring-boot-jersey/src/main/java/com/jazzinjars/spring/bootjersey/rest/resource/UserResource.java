package com.jazzinjars.spring.bootjersey.rest.resource;

import com.jazzinjars.spring.bootjersey.rest.model.User;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/users")
@Produces( {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML} )
@Consumes( {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML} )
public interface UserResource {

	@GET
	List getUsers(@QueryParam("companyName") String companyName);

	@GET
	@Path(value = "/{userId}")
	User findUserById(@PathParam("userId") int userId);

	@POST
	User createUser(@Valid User request);

	@PUT
	@Path(value = "/{userId}")
	User updateUser(@PathParam("userId") Integer userId, @Valid User request);

	@DELETE
	@Path(value = "/{userId}")
	void deleteUser(@PathParam("userId") Integer userId);
}
