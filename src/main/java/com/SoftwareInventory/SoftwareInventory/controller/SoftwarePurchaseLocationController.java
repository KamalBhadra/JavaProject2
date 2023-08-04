package com.SoftwareInventory.SoftwareInventory.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SoftwareInventory.SoftwareInventory.entity.PurchaseLocation;

import com.SoftwareInventory.SoftwareInventory.repository.PurchaseLocationRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/softwarepurchaselocation")
public class SoftwarePurchaseLocationController {
	@Autowired
	private PurchaseLocationRepository purchaseLocationRepository;

	@GetMapping("/")
	public List<PurchaseLocation> getAllLocations() {
		return purchaseLocationRepository.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<PurchaseLocation> getLocationById(@PathVariable(value = "id") Long locationId) {
		Optional<PurchaseLocation> locations = purchaseLocationRepository.findById(locationId);
		if (locations.isPresent()) {
			return ResponseEntity.ok().body(locations.get());
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@PostMapping("/")
	public PurchaseLocation createPurchaseLocation(@Valid @RequestBody PurchaseLocation purchaseLocations) {
		return purchaseLocationRepository.save(purchaseLocations);
	}

	@PutMapping("/{id}")
	public ResponseEntity<PurchaseLocation> updateLocations(@PathVariable(value = "id") Long locationId,
			@Valid @RequestBody PurchaseLocation locationDetails) {
		Optional<PurchaseLocation> locations = purchaseLocationRepository.findById(locationId);

		if (locations.isPresent()) {
			PurchaseLocation updatedPurchaseLocation = locations.get();
			updatedPurchaseLocation.setCity(locationDetails.getCity());
			updatedPurchaseLocation.setPersonname(locationDetails.getPersonname());
			updatedPurchaseLocation.setOrderdetails(locationDetails.getOrderdetails());
			updatedPurchaseLocation.setSoftwarename(locationDetails.getSoftwarename());
			purchaseLocationRepository.save(updatedPurchaseLocation);
			return ResponseEntity.ok().body(updatedPurchaseLocation);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletePurchaseLocation(@PathVariable(value = "id") Long locationId) {
		Optional<PurchaseLocation> locations = purchaseLocationRepository.findById(locationId);
		if (locations.isPresent()) {
			purchaseLocationRepository.delete(locations.get());
			return ResponseEntity.noContent().build();

		} else {
			return ResponseEntity.notFound().build();
		}
	}
}
