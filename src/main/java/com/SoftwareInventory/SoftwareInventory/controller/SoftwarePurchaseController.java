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
import com.SoftwareInventory.SoftwareInventory.entity.Purchase;
import com.SoftwareInventory.SoftwareInventory.repository.PurchaseRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/softwarepurchase")
public class SoftwarePurchaseController {
	
	@Autowired
	private PurchaseRepository purchaseRepository;
	
	@GetMapping("/")
	public List<Purchase> getAllSoftPurchases() {
		return purchaseRepository.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Purchase> getSotwaresPurchaseById(@PathVariable(value = "id") Long SoftwaresPurchaseId) {
		Optional<Purchase> softwaresPurchase = purchaseRepository.findById(SoftwaresPurchaseId);
		if (softwaresPurchase.isPresent()) {
			return ResponseEntity.ok().body(softwaresPurchase.get());
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@PostMapping("/")
	public Purchase creSoftwaresPurchase(@Valid @RequestBody Purchase softwaresPurchase) {
		return purchaseRepository.save(softwaresPurchase);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Purchase> updateSoftwaresPurchase(@PathVariable(value = "id") Long softwaresPurchaseId,
			@Valid @RequestBody Purchase softwaresPurchaseDetails) {
		Optional<Purchase> softwaresPurchase = purchaseRepository.findById(softwaresPurchaseId);

		if (softwaresPurchase.isPresent()) {
			Purchase updatedSoftwaresPerPurchase = softwaresPurchase.get();
			updatedSoftwaresPerPurchase.setOrderno(softwaresPurchaseDetails.getOrderno());
			updatedSoftwaresPerPurchase.setDate(softwaresPurchaseDetails.getDate());
			updatedSoftwaresPerPurchase.setSoftwarename(softwaresPurchaseDetails.getSoftwarename());
			purchaseRepository.save(updatedSoftwaresPerPurchase);
			return ResponseEntity.ok().body(updatedSoftwaresPerPurchase);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteSoftwaresPurchase(@PathVariable(value = "id") Long softwaresPurchaseId) {
		Optional<Purchase> softwaresPurchase = purchaseRepository.findById(softwaresPurchaseId);
		if (softwaresPurchase.isPresent()) {
			purchaseRepository.delete(softwaresPurchase.get());
			return ResponseEntity.noContent().build();

		} else {
			return ResponseEntity.notFound().build();
		}
	}

}
