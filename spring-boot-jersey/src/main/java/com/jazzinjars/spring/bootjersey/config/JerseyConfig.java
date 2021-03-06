package com.jazzinjars.spring.bootjersey.config;

import com.jazzinjars.spring.bootjersey.exception.UnhandledExceptionMapper;
import com.jazzinjars.spring.bootjersey.rest.UserComponent;
import com.jazzinjars.spring.bootjersey.rest.resource.UserResource;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.ServerProperties;
import org.springframework.stereotype.Component;

@Component
public class JerseyConfig extends ResourceConfig {

	public JerseyConfig() {
		registerApplicationProperties();
		registerApplicationApis();
	}

	private void registerApplicationApis() {
		register(UnhandledExceptionMapper.class);
		register(UserComponent.class);
	}

	private void registerApplicationProperties() {
		property(ServerProperties.BV_SEND_ERROR_IN_RESPONSE, true);
		property(ServerProperties.BV_DISABLE_VALIDATE_ON_EXECUTABLE_OVERRIDE_CHECK, true);
	}
}
