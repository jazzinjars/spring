package com.jazzinjars.spring.bootjersey.client;

import org.glassfish.jersey.client.JerseyClient;
import org.glassfish.jersey.client.JerseyClientBuilder;
import org.junit.Assert;
import org.junit.Test;

import javax.ws.rs.core.Response;

public class Jersey2ClientTest {

	@Test
	public void givenJerseyClient_whenGetEntity_thenRequestIsOK() {
		JerseyClient client = JerseyClientBuilder.createClient();
		Response response = client.target(ClientDataConstants.USER_URI + "?companyName=Stark Enterprise").request().get();

		System.out.println("Get User status: " + response.getStatus());

		String output = response.readEntity(String.class);
		System.out.println("Find User with output: " + output);

		Assert.assertEquals(200, response.getStatus());
	}
}
