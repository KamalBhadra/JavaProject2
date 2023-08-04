package com.SoftwareInventory.SoftwareInventory.service;

import java.util.List;
import java.util.Optional;

import com.SoftwareInventory.SoftwareInventory.entity.PurchaseLocation;


public interface SoftwarePurchaseLocation {

	   //retrieve all the locations
	   List<PurchaseLocation> getAllLocations();
	
	   //retrieve purchase location by id
	   Optional<PurchaseLocation> getLocationById(Long id);
	
	   
	   //save location data 
	   PurchaseLocation createLocation(PurchaseLocation purchaseLocation);
	
	
	   //update location data
	   PurchaseLocation updateLocations(Long id,PurchaseLocation locationDetails);
	   
	   //delete location data
	   void deletepurchaseLocation(long id);
	
	
	
}
