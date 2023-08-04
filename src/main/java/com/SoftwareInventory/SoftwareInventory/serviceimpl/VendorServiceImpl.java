package com.SoftwareInventory.SoftwareInventory.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.SoftwareInventory.SoftwareInventory.entity.SoftwaresVendor;
import com.SoftwareInventory.SoftwareInventory.repository.VendorsRepository;
import com.SoftwareInventory.SoftwareInventory.service.VendorsService;

@Service
public class VendorServiceImpl implements VendorsService {
    @Autowired
    private VendorsRepository vendorRepository;
	@Override
	public List<SoftwaresVendor> getAllVendors() {
		// TODO Auto-generated method stub
		return vendorRepository.findAll();
	}

	@Override
	public Optional<SoftwaresVendor> getVendorsById(Long id) {
		// TODO Auto-generated method stub
		return vendorRepository.findById(id);
	}

	@Override
	public SoftwaresVendor createVendor(SoftwaresVendor softwareVendor) {
		// TODO Auto-generated method stub
		return vendorRepository.save(softwareVendor);
	}

	@Override
	public SoftwaresVendor updateSoftwareVendors(Long id, SoftwaresVendor softwaresVendorDetails) {
		// TODO Auto-generated method stub
		Optional<SoftwaresVendor> softwaresvendor=vendorRepository.findById(id);
		if(softwaresvendor.isPresent()) {
			SoftwaresVendor updatedSoftwaresVendor= softwaresvendor.get();
			updatedSoftwaresVendor.setVendorname(softwaresVendorDetails.getVendorname());
			updatedSoftwaresVendor.setEmailid(softwaresVendorDetails.getEmailid());
			return vendorRepository.save(updatedSoftwaresVendor);
			
		}
		else {
			return null;
		}
	}

	@Override
	public void deleteVendor(long id) {
		// TODO Auto-generated method stub
		Optional<SoftwaresVendor> softwaresVendor=vendorRepository.findById(id);
		softwaresVendor.ifPresent(vendorRepository::delete);
	}

}
