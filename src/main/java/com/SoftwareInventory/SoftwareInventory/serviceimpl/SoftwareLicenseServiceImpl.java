package com.SoftwareInventory.SoftwareInventory.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SoftwareInventory.SoftwareInventory.entity.SoftwaresLicense;
import com.SoftwareInventory.SoftwareInventory.repository.SoftwaresLicenseRepository;
import com.SoftwareInventory.SoftwareInventory.service.SoftwaresLicenseService;

@Service
public class SoftwareLicenseServiceImpl implements SoftwaresLicenseService {
	@Autowired
	SoftwaresLicenseRepository softwaresLicenseRepository;

	@Override
	public List<SoftwaresLicense> getAllLicenses() {
		// TODO Auto-generated method stub
		return softwaresLicenseRepository.findAll();
	}

	@Override
	public Optional<SoftwaresLicense> getLicensesById(Long id) {
		// TODO Auto-generated method stub
		return softwaresLicenseRepository.findById(id);
	}

	@Override
	public SoftwaresLicense createSoftwareLicense(SoftwaresLicense softwareLicense) {
		// TODO Auto-generated method stub
		return softwaresLicenseRepository.save(softwareLicense);
	}

	@Override
	public SoftwaresLicense updateLicenses(Long id, SoftwaresLicense softwareLicenseDetails) {
		// TODO Auto-generated method stub
		Optional<SoftwaresLicense> softwaresLicense = softwaresLicenseRepository.findById(id);
		if (softwaresLicense.isPresent()) {
			SoftwaresLicense updatedSoftwaresLicense = softwaresLicense.get();
			updatedSoftwaresLicense.setLicensekey(softwareLicenseDetails.getLicensekey());
			updatedSoftwaresLicense.setExpdate(softwareLicenseDetails.getExpdate());
			updatedSoftwaresLicense.setNumberofusers(softwareLicenseDetails.getNumberofusers());
			return softwaresLicenseRepository.save(updatedSoftwaresLicense);

		} else {
			return null;
		}
	}

	@Override
	public void deleteLicenses(Long id) {
		// TODO Auto-generated method stub
		Optional<SoftwaresLicense> softwaresLicense = softwaresLicenseRepository.findById(id);
		softwaresLicense.ifPresent(softwaresLicenseRepository::delete);

	}

}
