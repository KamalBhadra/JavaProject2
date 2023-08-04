package com.SoftwareInventory.SoftwareInventory.service;

import java.util.List;
import java.util.Optional;

import com.SoftwareInventory.SoftwareInventory.entity.SoftwarePlatform;


public interface SoftwaresPlatformService {

	  
	    //get all platforms of software
	    List<SoftwarePlatform> getAllPlatforms();
	

	    //get software platforms by id
	    Optional<SoftwarePlatform> getPlateformById(Long id);
	    
	    
	    //save new details in data
	    SoftwarePlatform createPlatform(SoftwarePlatform softwarePlatform);
	    
	    //update software platform details
	    SoftwarePlatform updateSoftwaresPlatform(Long id,SoftwarePlatform softwarePlatformDetails);
	    

	    //delete software platforms
	    void deletePlateform(long id);
	
	
	

}
