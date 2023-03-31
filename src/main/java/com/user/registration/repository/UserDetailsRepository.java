package com.user.registration.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.user.registration.model.PersonalDetails;

public interface UserDetailsRepository extends JpaRepository<PersonalDetails, Integer>{

	PersonalDetails findByAadhar(String aadhar);
   
	@Query("SELECT person,address FROM PersonalDetails person INNER JOIN Address address ON person.address=address.addrID where person.userID=?1")
	PersonalDetails findByExtraId(Integer id);
	
}
