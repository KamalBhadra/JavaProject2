package com.SoftwareInventory.SoftwareInventory.service;

import java.util.List;
import java.util.Optional;

import com.SoftwareInventory.SoftwareInventory.entity.Softwares;

public interface SoftwaresService {
	
	//Retrieve all the softwares
	List<Softwares> getAllSoftwares();
	
	//Retrieve a softwares by id 
	Optional<Softwares> getSoftwaresById(Long id);
	
	//Save new software to data 
	Softwares createSoftware(Softwares softwares);
	
	//update an existing software to data
	Softwares updateSoftwares(Long id,Softwares softwaresDetails);
	
	//Delete software by id from data.
	void deleteSoftware(long id);

}
