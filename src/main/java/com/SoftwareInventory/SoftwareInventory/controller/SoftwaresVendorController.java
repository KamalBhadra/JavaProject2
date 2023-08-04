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

import com.SoftwareInventory.SoftwareInventory.entity.SoftwaresVendor;

import com.SoftwareInventory.SoftwareInventory.repository.VendorsRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/softwarevendor")
public class SoftwaresVendorController {
	@Autowired
	private VendorsRepository vendorRepository;

	@GetMapping("/")
	public List<SoftwaresVendor> getAllSoftwaresVendors() {
		return vendorRepository.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<SoftwaresVendor> getSotwaresVendorsById(@PathVariable(value = "id") Long SoftwaresVendorId) {
		Optional<SoftwaresVendor> softwaresVendor = vendorRepository.findById(SoftwaresVendorId);
		if (softwaresVendor.isPresent()) {
			return ResponseEntity.ok().body(softwaresVendor.get());
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@PostMapping("/")
	public SoftwaresVendor creSoftwaresVendor(@Valid @RequestBody SoftwaresVendor softwaresVendor) {
		return vendorRepository.save(softwaresVendor);
	}

	@PutMapping("/{id}")
	public ResponseEntity<SoftwaresVendor> updateSoftwaresVendor(@PathVariable(value = "id") Long softwaresVendorId,
			@Valid @RequestBody SoftwaresVendor softwaresVendorDetails) {
		Optional<SoftwaresVendor> softwaresVendor = vendorRepository.findById(softwaresVendorId);

		if (softwaresVendor.isPresent()) {
			SoftwaresVendor updatedSoftwaresVendor = softwaresVendor.get();
			updatedSoftwaresVendor.setVendorname(softwaresVendorDetails.getVendorname());
			updatedSoftwaresVendor.setEmailid(softwaresVendorDetails.getEmailid());
			vendorRepository.save(updatedSoftwaresVendor);
			return ResponseEntity.ok().body(updatedSoftwaresVendor);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteSoftwaresVendors(@PathVariable(value = "id") Long softwaresVendorId) {
		Optional<SoftwaresVendor> softwaresVendor = vendorRepository.findById(softwaresVendorId);
		if (softwaresVendor.isPresent()) {
			vendorRepository.delete(softwaresVendor.get());
			return ResponseEntity.noContent().build();

		} else {
			return ResponseEntity.notFound().build();
		}
	}
}
