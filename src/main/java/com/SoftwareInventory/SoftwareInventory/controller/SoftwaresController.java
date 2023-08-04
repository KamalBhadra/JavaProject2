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

import com.SoftwareInventory.SoftwareInventory.entity.Softwares;
import com.SoftwareInventory.SoftwareInventory.repository.SoftwareRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/software")
public class SoftwaresController {
	@Autowired
	private SoftwareRepository softwareRepository;

	@GetMapping("/")
	public List<Softwares> getAllSoftwares() {
		return softwareRepository.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Softwares> getSotwaresById(@PathVariable(value = "id") Long SoftwaresId) {
		Optional<Softwares> softwares = softwareRepository.findById(SoftwaresId);
		if (softwares.isPresent()) {
			return ResponseEntity.ok().body(softwares.get());
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@PostMapping("/")
	public Softwares creSoftwares(@Valid @RequestBody Softwares softwares) {
		return softwareRepository.save(softwares);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Softwares> updateSoftwares(@PathVariable(value = "id") Long softwaresId,
			@Valid @RequestBody Softwares softwaresDetails) {
		Optional<Softwares> softwares = softwareRepository.findById(softwaresId);

		if (softwares.isPresent()) {
			Softwares updatedSoftwares = softwares.get();
			updatedSoftwares.setName(softwaresDetails.getName());
			updatedSoftwares.setVersion(softwaresDetails.getVersion());
			updatedSoftwares.setPublisher(softwaresDetails.getPublisher());
			updatedSoftwares.setQuantity(softwaresDetails.getQuantity());
			softwareRepository.save(updatedSoftwares);
			return ResponseEntity.ok().body(updatedSoftwares);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteSoftwares(@PathVariable(value = "id") Long softwaresId) {
		Optional<Softwares> softwares = softwareRepository.findById(softwaresId);
		if (softwares.isPresent()) {
			softwareRepository.delete(softwares.get());
			return ResponseEntity.noContent().build();

		} else {
			return ResponseEntity.notFound().build();
		}
	}
}
