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

import com.SoftwareInventory.SoftwareInventory.entity.SoftwaresCatagory;

import com.SoftwareInventory.SoftwareInventory.repository.SoftwaresCatagoryRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/softwarecatagory")
public class SoftwaresCatagoryController {
	@Autowired
	private SoftwaresCatagoryRepository softwaresCatagoryRepository;

	@GetMapping("/")
	public List<SoftwaresCatagory> getAllSoftwaresCatagory() {
		return softwaresCatagoryRepository.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<SoftwaresCatagory> getSotwaresCatagoryById(
			@PathVariable(value = "id") Long SoftwaresCatagoryId) {
		Optional<SoftwaresCatagory> softwaresCatagory = softwaresCatagoryRepository.findById(SoftwaresCatagoryId);
		if (softwaresCatagory.isPresent()) {
			return ResponseEntity.ok().body(softwaresCatagory.get());
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@PostMapping("/")
	public SoftwaresCatagory creSoftwaresCatagory(@Valid @RequestBody SoftwaresCatagory softwaresCatagory) {
		return softwaresCatagoryRepository.save(softwaresCatagory);
	}

	@PutMapping("/{id}")
	public ResponseEntity<SoftwaresCatagory> updateSoftwaresCatagory(
			@PathVariable(value = "id") Long softwaresCatagoryId,
			@Valid @RequestBody SoftwaresCatagory softwaresCatagoryDetails) {
		Optional<SoftwaresCatagory> softwaresCatagory = softwaresCatagoryRepository.findById(softwaresCatagoryId);

		if (softwaresCatagory.isPresent()) {
			SoftwaresCatagory updatedSoftwaresCatagory = softwaresCatagory.get();
			updatedSoftwaresCatagory.setName(softwaresCatagoryDetails.getName());
			updatedSoftwaresCatagory.setDescription(softwaresCatagoryDetails.getDescription());

			softwaresCatagoryRepository.save(updatedSoftwaresCatagory);
			return ResponseEntity.ok().body(updatedSoftwaresCatagory);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteSoftwaresCatagory(@PathVariable(value = "id") Long softwaresCatagoryId) {
		Optional<SoftwaresCatagory> softwaresCatagory = softwaresCatagoryRepository.findById(softwaresCatagoryId);
		if (softwaresCatagory.isPresent()) {
			softwaresCatagoryRepository.delete(softwaresCatagory.get());
			return ResponseEntity.noContent().build();

		} else {
			return ResponseEntity.notFound().build();
		}
	}
}
