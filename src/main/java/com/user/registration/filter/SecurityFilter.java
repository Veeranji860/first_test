package com.user.registration.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.user.registration.jwt.TokenManager;
import com.user.registration.service.UserDetailsService;

@Component
public class SecurityFilter extends OncePerRequestFilter {

	@Autowired
	private TokenManager jwtUtil;
	@Autowired
	private UserDetailsService userDetailsService;

	@Override
	protected void doFilterInternal(
			HttpServletRequest request, 
			HttpServletResponse response, 
			FilterChain filterChain)
					throws ServletException, IOException {

		String token=request.getHeader("Authorization");
		if(token!=null) {

			String username=jwtUtil.getClaims(token).getSubject();
			
			if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
				/*
				 * UserDetails user=userDetailsService.loadUserName(username); boolean
				 * isValid=jwtUtil.validateToken(token, user.getUsername()); if(isValid) {
				 * UsernamePasswordAuthenticationToken authToken=new
				 * UsernamePasswordAuthenticationToken(username, user.getPassword(),
				 * user.getAuthorities()); authToken.setDetails(new
				 * WebAuthenticationDetailsSource().buildDetails(request));
				 * SecurityContextHolder.getContext().setAuthentication(authToken); }
				 */}
		}
		filterChain.doFilter(request, response);
	}

}
