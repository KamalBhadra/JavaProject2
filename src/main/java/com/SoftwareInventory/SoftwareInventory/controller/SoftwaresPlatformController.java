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

import com.SoftwareInventory.SoftwareInventory.entity.SoftwarePlatform;

import com.SoftwareInventory.SoftwareInventory.repository.PlatformRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/softwaresplatform")
public class SoftwaresPlatformController {
	@Autowired
	private PlatformRepository platformRepository;

	@GetMapping("/")
	public List<SoftwarePlatform> getAllSoftwaresVendors() {
		return platformRepository.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<SoftwarePlatform> getSotwaresPlatformsById(
			@PathVariable(value = "id") Long SoftwaresPlatformId) {
		Optional<SoftwarePlatform> softwaresPlatform = platformRepository.findById(SoftwaresPlatformId);
		if (softwaresPlatform.isPresent()) {
			return ResponseEntity.ok().body(softwaresPlatform.get());
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@PostMapping("/")
	public SoftwarePlatform creSoftwaresPlatform(@Valid @RequestBody SoftwarePlatform softwaresPlatform) {
		return platformRepository.save(softwaresPlatform);
	}

	@PutMapping("/{id}")
	public ResponseEntity<SoftwarePlatform> updateSoftwaresPlatform(
			@PathVariable(value = "id") Long softwaresPlatformId,
			@Valid @RequestBody SoftwarePlatform softwaresPlatformDetails) {
		Optional<SoftwarePlatform> softwaresPlatform = platformRepository.findById(softwaresPlatformId);

		if (softwaresPlatform.isPresent()) {
			SoftwarePlatform updatedSoftwaresPlatform = softwaresPlatform.get();
			updatedSoftwaresPlatform.setPlatform(softwaresPlatformDetails.getPlatform());
			updatedSoftwaresPlatform.setOperatingsystem(softwaresPlatformDetails.getOperatingsystem());
			platformRepository.save(updatedSoftwaresPlatform);
			return ResponseEntity.ok().body(updatedSoftwaresPlatform);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteSoftwaresVendors(@PathVariable(value = "id") Long softwaresPlatformId) {
		Optional<SoftwarePlatform> softwaresPlatform = platformRepository.findById(softwaresPlatformId);
		if (softwaresPlatform.isPresent()) {
			platformRepository.delete(softwaresPlatform.get());
			return ResponseEntity.noContent().build();

		} else {
			return ResponseEntity.notFound().build();
		}
	}

}
