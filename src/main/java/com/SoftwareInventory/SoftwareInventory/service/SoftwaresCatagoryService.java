package com.SoftwareInventory.SoftwareInventory.service;

import java.util.List;
import java.util.Optional;
import com.SoftwareInventory.SoftwareInventory.entity.SoftwaresCatagory;

public interface SoftwaresCatagoryService {

	// Retrieve all the softwarescatagory
	List<SoftwaresCatagory> getAllSoftwaresCatagory();

	// Retrieve a softwarescatagory by id
	Optional<SoftwaresCatagory> getSoftwaresCatagoryById(Long id);

	// Save new softwarecatagory to data
	SoftwaresCatagory createSoftwareCatagory(SoftwaresCatagory softwaresCatagory);

	// update an existing softwarecatagory to data
	SoftwaresCatagory updateSoftwaresCatagory(Long id, SoftwaresCatagory softwaresCatagoryDetails);

	// Delete softwarecatagory by id from data.
	void deleteSoftwaresCatagory(long id);
}
