package com.jazzinjars.spring.bootjersey.client;

import com.jazzinjars.spring.bootjersey.rest.model.User;
import org.junit.Assert;
import org.junit.Test;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


public class JAXRSClientTest {

//	@Test
	public void givenJaxRsClient_thenRequestIsOK() {
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(ClientDataConstants.USER_URI);

		User data = ClientDataConstants.createDummyUser();

		Response response = target.request().post(Entity.entity(data, MediaType.APPLICATION_JSON));
		System.out.println("Create User status: " + response.getStatus());

		String output = response.readEntity(String.class);
		System.out.println("Create User with output: " + output);

		Assert.assertEquals(200, response.getStatus());
	}
}
