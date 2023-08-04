package com.SoftwareInventory.SoftwareInventory.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SoftwareInventory.SoftwareInventory.entity.Purchase;

import com.SoftwareInventory.SoftwareInventory.repository.PurchaseRepository;
import com.SoftwareInventory.SoftwareInventory.service.SoftwarePurchaseService;

@Service
public class SoftwarePurchaseServiceImpl implements SoftwarePurchaseService{
    @Autowired
    private PurchaseRepository purchaseRepository;
	
    @Override
	public List<Purchase> getAllPurchaseData() {
		// TODO Auto-generated method stub
		return purchaseRepository.findAll();
	}

	@Override
	public Optional<Purchase> getPurchaseDataById(Long id) {
		// TODO Auto-generated method stub
		return purchaseRepository.findById(id);
	}

	@Override
	public Purchase createPurchase(Purchase purchaseSoftware) {
		// TODO Auto-generated method stub
		return purchaseRepository.save(purchaseSoftware);
	}

	@Override
	public Purchase updatePurchaseDetails(Long id, Purchase purchaseDataDetails) {
		// TODO Auto-generated method stub
				Optional<Purchase> softwarespurchase=purchaseRepository.findById(id);
				if(softwarespurchase.isPresent()) {
					Purchase updatedSoftwaresPurchase= softwarespurchase.get();
					updatedSoftwaresPurchase.setOrderno(purchaseDataDetails.getOrderno());
					updatedSoftwaresPurchase.setDate(purchaseDataDetails.getDate());
					updatedSoftwaresPurchase.setSoftwarename(purchaseDataDetails.getSoftwarename());
					return purchaseRepository.save(updatedSoftwaresPurchase);
					
				}
				else {
					return null;
				}
	}

	@Override
	public void deletePurchaseData(long id) {
		Optional<Purchase> softwaresPurchase=purchaseRepository.findById(id);
		softwaresPurchase.ifPresent(purchaseRepository::delete);
		
	}

}
