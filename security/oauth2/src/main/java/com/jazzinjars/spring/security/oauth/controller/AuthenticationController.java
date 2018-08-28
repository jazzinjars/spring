package com.jazzinjars.spring.security.oauth.controller;

import com.jazzinjars.spring.security.oauth.config.JwtTokenUtil;
import com.jazzinjars.spring.security.oauth.model.AuthToken;
import com.jazzinjars.spring.security.oauth.model.LoginUser;
import com.jazzinjars.spring.security.oauth.model.User;
import com.jazzinjars.spring.security.oauth.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/token")
@CrossOrigin(origins = "*", maxAge = 3600)
public class AuthenticationController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private UserService userService;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@RequestMapping(value = "/generate-token", method = RequestMethod.POST)
	public ResponseEntity<?> register(@RequestBody LoginUser loginUser) throws AuthenticationException {

		final Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginUser.getUsername(), loginUser.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);
		final User user = userService.findOne(loginUser.getUsername());
		final String token = jwtTokenUtil.generateToken(user);
		return ResponseEntity.ok(new AuthToken(token));

	}
}
