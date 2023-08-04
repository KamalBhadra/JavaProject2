package com.SoftwareInventory.SoftwareInventory.service;

import java.util.List;
import java.util.Optional;

import com.SoftwareInventory.SoftwareInventory.entity.Purchase;


public interface SoftwarePurchaseService {

	   //get all purchase details of the software
	   List<Purchase> getAllPurchaseData();
	
	   
	   //retriving purchase details by id
	   Optional<Purchase> getPurchaseDataById(Long id);
	   
	   //save purchase details to  data
	   Purchase createPurchase(Purchase purchaseSoftware);
	   
	   //update purchase data 
	   Purchase updatePurchaseDetails(Long id,Purchase purchaseDataDetails);
	   
	   //delete purchase data
	   void deletePurchaseData(long id);
	   
	
}
