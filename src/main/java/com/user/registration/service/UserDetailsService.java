package com.user.registration.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.user.registration.dto.AddressUser;
import com.user.registration.dto.PersonalDetailsUser;
import com.user.registration.exception.UserNotFound;
import com.user.registration.model.Address;
import com.user.registration.model.PersonalDetails;
import com.user.registration.model.User;
import com.user.registration.repository.AddressRepository;
import com.user.registration.repository.UserDetailsRepository;
//import com.user.registration.repository.UserRepository;

@Service
public class UserDetailsService {

	@Autowired
	private UserDetailsRepository repository;
	@Autowired
	private AddressRepository child;
	/*
	 * @Autowired private UserRepository user;
	 */

	public Integer saveUserDetails(PersonalDetailsUser user) {

		PersonalDetails data = new PersonalDetails();
		data.setEmail(user.getEmail());
		data.setFirstName(user.getFirstName());
		data.setLastName(user.getLastName());
		data.setMiddleName(user.getMiddleName());
		data.setMobileNumber(user.getMobileNumber());
		data.setAadhar(user.getAadhar());
		data.setAddress(new Address());
		data.getAddress().setAddrLine1(user.getAddress().getAddrLine1());
		data.getAddress().setAddrLine2(user.getAddress().getAddrLine2());
		data.getAddress().setAddrLine3(user.getAddress().getAddrLine3());
		data.getAddress().setCity(user.getAddress().getCity());
		data.getAddress().setState(user.getAddress().getState());
		data.getAddress().setPostelCode(user.getAddress().getPostelCode());

		PersonalDetails save = repository.save(data);

		return save.getUserID();
	}

	public PersonalDetailsUser retrieveUserDetails(String aadhar) throws UserNotFound {
		PersonalDetails findByAadhar = repository.findByAadhar(aadhar);

		if (findByAadhar != null) {
			PersonalDetailsUser user = new PersonalDetailsUser();
			user.setAadhar(findByAadhar.getAadhar());
			user.setEmail(findByAadhar.getEmail());
			user.setFirstName(findByAadhar.getFirstName());
			user.setLastName(findByAadhar.getLastName());
			user.setMiddleName(findByAadhar.getLastName());
			user.setMobileNumber(findByAadhar.getMobileNumber());
			user.setAddress(new AddressUser());
			user.getAddress().setAddrLine1(findByAadhar.getAddress().getAddrLine1());
			user.getAddress().setAddrLine2(findByAadhar.getAddress().getAddrLine2());
			user.getAddress().setAddrLine3(findByAadhar.getAddress().getAddrLine3());
			user.getAddress().setCity(findByAadhar.getAddress().getCity());
			user.getAddress().setState(findByAadhar.getAddress().getState());
			user.getAddress().setPostelCode(findByAadhar.getAddress().getPostelCode());
			return user;
		} else {
			throw new UserNotFound("Unable to Find the User Details");
		}
	}

	public void updateUser(Integer id, PersonalDetailsUser personalDetails) throws UserNotFound {
		// TODO Auto-generated method stub
		// PersonalDetails user = repository.findByExtraId(id);
		PersonalDetails user = repository.findByExtraId(id)!=null? repository.findById(id).get() : null;
		if (user != null) {
			user.setEmail(personalDetails.getEmail());
			user.setAadhar(personalDetails.getAadhar());
			user.setFirstName(personalDetails.getFirstName());
			user.setLastName(personalDetails.getLastName());
			user.setMiddleName(personalDetails.getMiddleName());
			user.setEmail(personalDetails.getEmail());
			user.setMobileNumber(personalDetails.getMobileNumber());
			if(user.getAddress()!=null) {
				user.getAddress().setAddrLine1(personalDetails.getAddress().getAddrLine1());
				user.getAddress().setAddrLine2(personalDetails.getAddress().getAddrLine2());
				user.getAddress().setAddrLine3(personalDetails.getAddress().getAddrLine3());
				user.getAddress().setCity(personalDetails.getAddress().getCity());
				user.getAddress().setState(personalDetails.getAddress().getState());
				user.getAddress().setPostelCode(personalDetails.getAddress().getPostelCode());
				
			}
			
			repository.save(user);
		} else {
			throw new UserNotFound("User Details Not available Please Register");
		}

	}
	
	/*
	 * public UserDetails loadUserName(String userName) throws UserNotFound { User
	 * findByUserName = user.findByUserName(userName); if(findByUserName==null) {
	 * throw new UserNotFound("User Name not available"); List<GrantedAuthority>
	 * authorities =findByUserName.getRole().stream().map(role->new
	 * SimpleGrantedAuthority("")).collect(Collectors.toList()); return new
	 * org.springframework.security.core.userdetails.User(userName,findByUserName.
	 * getPassword(),authorities); }
	 * 
	 * }
	 */
}
