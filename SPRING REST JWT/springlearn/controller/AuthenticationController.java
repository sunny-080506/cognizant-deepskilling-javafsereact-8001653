package com.cognizant.springlearn.controller;

import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
public class AuthenticationController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(AuthenticationController.class);
	
	@GetMapping("/authenticate")
	public Map<String, String> authenticate(@RequestHeader("Authorization") String authHeader) {
		LOGGER.info("START - authenticate()");
		LOGGER.debug("Authorization Header: {}", authHeader);
		
		String user = getUser(authHeader);
		LOGGER.debug("User: {}", user);
		
		String token = generateJwt(user);
		LOGGER.debug("Generated Token: {}", token);
		
		Map<String, String> response = new HashMap<>();
		response.put("token", token);
		
		LOGGER.info("END - authenticate()");
		return response;
	}
	
	private String getUser(String authHeader) {
		LOGGER.info("START - getUser()");
		
		String encodedCredentials = authHeader.substring(7);
		LOGGER.debug("Encoded Credentials: {}", encodedCredentials);
		
		byte[] decodedBytes = Base64.getDecoder().decode(encodedCredentials);
		String credentials = new String(decodedBytes);
		LOGGER.debug("Decoded Credentials: {}", credentials);
		
		String user = credentials.split(":")[0];
		LOGGER.debug("User: {}", user);
		
		LOGGER.info("END - getUser()");
		return user;
	}
	
	private String generateJwt(String user) {
		LOGGER.info("START - generateJwt() - user: {}", user);
		
		JwtBuilder builder = Jwts.builder();
		builder.setSubject(user);
		builder.setIssuedAt(new Date());
		builder.setExpiration(new Date((new Date()).getTime() + 1200000)); // 20 minutes
		builder.signWith(SignatureAlgorithm.HS256, "secretkey");
		
		String token = builder.compact();
		LOGGER.debug("Generated Token: {}", token);
		
		LOGGER.info("END - generateJwt()");
		return token;
	}
}
