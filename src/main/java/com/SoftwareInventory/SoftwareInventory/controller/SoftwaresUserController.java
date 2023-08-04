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

import com.SoftwareInventory.SoftwareInventory.entity.SoftwaresUser;

import com.SoftwareInventory.SoftwareInventory.repository.SoftwaresUserRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/softwaresuser")
public class SoftwaresUserController {

	@Autowired
	private SoftwaresUserRepository softwareUserRepository;

	@GetMapping("/")
	public List<SoftwaresUser> getAllSoftwaresUsers() {
		return softwareUserRepository.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<SoftwaresUser> getSotwaresUserById(@PathVariable(value = "id") Long SoftwaresUserId) {
		Optional<SoftwaresUser> softwaresUser = softwareUserRepository.findById(SoftwaresUserId);
		if (softwaresUser.isPresent()) {
			return ResponseEntity.ok().body(softwaresUser.get());
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@PostMapping("/")
	public SoftwaresUser creSoftwaresUser(@Valid @RequestBody SoftwaresUser softwaresUser) {
		return softwareUserRepository.save(softwaresUser);
	}

	@PutMapping("/{id}")
	public ResponseEntity<SoftwaresUser> updateSoftwaresUser(@PathVariable(value = "id") Long softwaresUserId,
			@Valid @RequestBody SoftwaresUser softwaresUserDetails) {
		Optional<SoftwaresUser> softwaresUser = softwareUserRepository.findById(softwaresUserId);

		if (softwaresUser.isPresent()) {
			SoftwaresUser updatedSoftwaresUser = softwaresUser.get();
			updatedSoftwaresUser.setSoftwareusername(softwaresUserDetails.getSoftwareusername());
			updatedSoftwaresUser.setSoftwarecatagory(softwaresUserDetails.getSoftwarecatagory());
			softwareUserRepository.save(updatedSoftwaresUser);
			return ResponseEntity.ok().body(updatedSoftwaresUser);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteSoftwares(@PathVariable(value = "id") Long softwaresUserId) {
		Optional<SoftwaresUser> softwaresUser = softwareUserRepository.findById(softwaresUserId);
		if (softwaresUser.isPresent()) {
			softwareUserRepository.delete(softwaresUser.get());
			return ResponseEntity.noContent().build();

		} else {
			return ResponseEntity.notFound().build();
		}
	}
}
