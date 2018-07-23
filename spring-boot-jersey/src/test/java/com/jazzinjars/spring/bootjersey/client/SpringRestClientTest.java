package com.jazzinjars.spring.bootjersey.client;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class SpringRestClientTest {

	@Test
	public void givenSpringClient_whenPostEntity_thenRequestIsOK() {
		RestTemplate restTemplate = new RestTemplate();
		HttpEntity entity = new HttpEntity(ClientDataConstants.createDummyUser());

		ResponseEntity responseEntity = restTemplate.exchange(ClientDataConstants.USER_URI, HttpMethod.POST, entity, String.class);

		System.out.println("Create User status: " + responseEntity.getStatusCode());

		Assert.assertEquals(200, responseEntity.getStatusCode().value());
	}
}
