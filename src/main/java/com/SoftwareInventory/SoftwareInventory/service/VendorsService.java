package com.SoftwareInventory.SoftwareInventory.service;

import java.util.List;
import java.util.Optional;

import com.SoftwareInventory.SoftwareInventory.entity.SoftwaresVendor;

public interface VendorsService {
	
	//retrive all vendors
	List<SoftwaresVendor> getAllVendors();
	
	//retrive vendrors by id
	Optional<SoftwaresVendor> getVendorsById(Long id);
	
	//save new vendor to data
	SoftwaresVendor createVendor(SoftwaresVendor softwareVendor);
	
	//update software vendor to data
	SoftwaresVendor updateSoftwareVendors(Long id,SoftwaresVendor softwaresVendorDetails);
	
	//delete software from data
	void deleteVendor(long id);
	

}
