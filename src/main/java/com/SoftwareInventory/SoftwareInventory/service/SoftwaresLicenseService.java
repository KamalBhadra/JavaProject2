package com.SoftwareInventory.SoftwareInventory.service;

import java.util.List;
import java.util.Optional;

import com.SoftwareInventory.SoftwareInventory.entity.SoftwaresLicense;

public interface SoftwaresLicenseService {
	
	//retrieve all the licenses
	List<SoftwaresLicense> getAllLicenses();
	
	
	//retrieve license by id
	Optional<SoftwaresLicense> getLicensesById(Long id);
	
	//save new software license to data.
	SoftwaresLicense createSoftwareLicense(SoftwaresLicense softwareLicense);
	
	
	//update software Licenses
	SoftwaresLicense updateLicenses(Long id,SoftwaresLicense softwareLicenseDetails);
	
	//Delete Softwares Licenses
	void deleteLicenses(Long id);
	

}
