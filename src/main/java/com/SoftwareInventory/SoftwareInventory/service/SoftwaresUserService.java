package com.SoftwareInventory.SoftwareInventory.service;
import java.util.List;
import java.util.Optional;
import com.SoftwareInventory.SoftwareInventory.entity.SoftwaresUser;

public interface SoftwaresUserService {
	
    //retrieving all the software users
	List<SoftwaresUser> getAllSoftwaresUser();
	
	//retrive a softwareuser by id
	Optional<SoftwaresUser> getAllSoftwaresUserById(Long id);
	
	//save new softwareuser to data
	SoftwaresUser createSoftwaresIUser(SoftwaresUser softwaresUser);
	
	//update software user by id
	SoftwaresUser updateSoftwareUser(Long id,SoftwaresUser softwareUsersDetail);
	
	//Delete software user from data
	void deleteSoftwaresUser(Long id);

}
