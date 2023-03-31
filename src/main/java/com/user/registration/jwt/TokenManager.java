package com.user.registration.jwt;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class TokenManager {

	@Value("${app.secreate}")
	private String secreate;

	public String generateToken() {
		return Jwts.builder().setSubject("veera").setIssuedAt(new Date()).signWith(SignatureAlgorithm.HS256, secreate)
				.compact();
	}

	public Claims getClaims(String token) {
		return Jwts.parser().setSigningKey(secreate).parseClaimsJws(generateToken()).getBody();
	}

	public boolean isValidToken(String token) {
		String subject = getClaims(token).getSubject();
		return Jwts.parser().setSigningKey(secreate).parseClaimsJws(token).equals(subject);
	}
}
