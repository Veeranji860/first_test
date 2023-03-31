/**
 * 
 */
package com.user.registration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.user.registration.dto.PersonalDetailsUser;
import com.user.registration.exception.UserNotFound;
import com.user.registration.jwt.TokenManager;
import com.user.registration.service.UserDetailsService;
import com.user.registration.success.SuccessCode;

/**
 * @author hp
 *
 */
@RestController
@RequestMapping(value="${app.path}")
public class UserRegidtrationController {
	
	@Autowired
	private RestTemplate template;
	
	@Autowired
	private TokenManager token;

	@Autowired
	private UserDetailsService service;

	@PostMapping(value = {"/userDetails","/api/javainuse"})
	public String userRegistrationDetails(@RequestBody PersonalDetailsUser personalDetails) {
		Integer saveUserDetails = service.saveUserDetails(personalDetails);

		return "User Registred Successfully with " + saveUserDetails;
	}

	@GetMapping(value = {"/getUser","/api/javainuse"},produces = {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<PersonalDetailsUser> getDetails(@RequestParam String aadhar) throws UserNotFound {
		PersonalDetailsUser retrieveUserDetails = service.retrieveUserDetails(aadhar);

		return new ResponseEntity<PersonalDetailsUser>(retrieveUserDetails, HttpStatus.OK);
	}
	
	@PutMapping(value = {"/getUserUpdate","/api/javainuse"})
	public ResponseEntity<SuccessCode> getDetailsUpdate(@RequestParam Integer id,@RequestBody PersonalDetailsUser personalDetails) throws UserNotFound {
		
		service.updateUser(id, personalDetails);
		SuccessCode re=new SuccessCode();
		re.setCode("10006");
		re.setMessage("Details are saved Successfully");

		return new ResponseEntity<SuccessCode>(re,HttpStatus.OK);
	}
	@GetMapping(value = {"/getRestTemplate","/api/javainuse"})
	public ResponseEntity<String> getData() {
		String tokenG=token.generateToken();
		System.out.println(token.getClaims(tokenG));
         return template.getForEntity("https://reqres.in/api/users?page=2", String.class);
	}

}
