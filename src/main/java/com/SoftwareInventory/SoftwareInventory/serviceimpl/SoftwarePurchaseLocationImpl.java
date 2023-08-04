package com.SoftwareInventory.SoftwareInventory.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SoftwareInventory.SoftwareInventory.entity.PurchaseLocation;

import com.SoftwareInventory.SoftwareInventory.repository.PurchaseLocationRepository;
import com.SoftwareInventory.SoftwareInventory.service.SoftwarePurchaseLocation;

@Service
public class SoftwarePurchaseLocationImpl implements SoftwarePurchaseLocation {
	@Autowired
	private PurchaseLocationRepository purchaseLocationRepository;

	@Override
	public List<PurchaseLocation> getAllLocations() {
		// TODO Auto-generated method stub
		return purchaseLocationRepository.findAll();
	}

	@Override
	public Optional<PurchaseLocation> getLocationById(Long id) {
		// TODO Auto-generated method stub
		return purchaseLocationRepository.findById(id);
	}

	@Override
	public PurchaseLocation createLocation(PurchaseLocation purchaseLocation) {
		// TODO Auto-generated method stub
		return purchaseLocationRepository.save(purchaseLocation);
	}

	@Override
	public PurchaseLocation updateLocations(Long id, PurchaseLocation locationDetails) {
		Optional<PurchaseLocation> purchaseLocation = purchaseLocationRepository.findById(id);
		if (purchaseLocation.isPresent()) {
			PurchaseLocation updatedPurchaseLocation = purchaseLocation.get();
			updatedPurchaseLocation.setCity(locationDetails.getCity());
			updatedPurchaseLocation.setPersonname(locationDetails.getPersonname());
			updatedPurchaseLocation.setOrderdetails(locationDetails.getOrderdetails());
			updatedPurchaseLocation.setSoftwarename(locationDetails.getSoftwarename());

			return purchaseLocationRepository.save(updatedPurchaseLocation);

		} else {
			return null;
		}
	}

	@Override
	public void deletepurchaseLocation(long id) {

		Optional<PurchaseLocation> purchaseLocation = purchaseLocationRepository.findById(id);
		purchaseLocation.ifPresent(purchaseLocationRepository::delete);
	}

}
