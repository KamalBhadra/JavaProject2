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

import com.SoftwareInventory.SoftwareInventory.entity.SoftwaresLicense;

import com.SoftwareInventory.SoftwareInventory.repository.SoftwaresLicenseRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/softwareslicense")
public class SoftwaresLicenseController {

	@Autowired
	private SoftwaresLicenseRepository softwaresLicenseRepository;

	@GetMapping("/")
	public List<SoftwaresLicense> getAllSoftwaresLicenses() {
		return softwaresLicenseRepository.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<SoftwaresLicense> getSotwaresLicenseById(
			@PathVariable(value = "id") Long SoftwaresLicenseId) {
		Optional<SoftwaresLicense> softwaresLicense = softwaresLicenseRepository.findById(SoftwaresLicenseId);
		if (softwaresLicense.isPresent()) {
			return ResponseEntity.ok().body(softwaresLicense.get());
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@PostMapping("/")
	public SoftwaresLicense creSoftwaresLicense(@Valid @RequestBody SoftwaresLicense softwaresLicense) {
		return softwaresLicenseRepository.save(softwaresLicense);
	}

	@PutMapping("/{id}")
	public ResponseEntity<SoftwaresLicense> updateSoftwaresLicense(@PathVariable(value = "id") Long softwaresLicenseId,
			@Valid @RequestBody SoftwaresLicense softwaresLicenseDetails) {
		Optional<SoftwaresLicense> softwaresLicense = softwaresLicenseRepository.findById(softwaresLicenseId);

		if (softwaresLicense.isPresent()) {
			SoftwaresLicense updatedSoftwaresLicense = softwaresLicense.get();
			updatedSoftwaresLicense.setLicensekey(softwaresLicenseDetails.getLicensekey());
			updatedSoftwaresLicense.setExpdate(softwaresLicenseDetails.getExpdate());
			updatedSoftwaresLicense.setNumberofusers(softwaresLicenseDetails.getNumberofusers());
			softwaresLicenseRepository.save(updatedSoftwaresLicense);
			return ResponseEntity.ok().body(updatedSoftwaresLicense);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteSoftwaresLicense(@PathVariable(value = "id") Long softwaresLicenseId) {
		Optional<SoftwaresLicense> softwaresLicense = softwaresLicenseRepository.findById(softwaresLicenseId);
		if (softwaresLicense.isPresent()) {
			softwaresLicenseRepository.delete(softwaresLicense.get());
			return ResponseEntity.noContent().build();

		} else {
			return ResponseEntity.notFound().build();
		}
	}

}
