package com.SoftwareInventory.SoftwareInventory.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SoftwareInventory.SoftwareInventory.entity.SoftwaresCatagory;

import com.SoftwareInventory.SoftwareInventory.repository.SoftwaresCatagoryRepository;
import com.SoftwareInventory.SoftwareInventory.service.SoftwaresCatagoryService;

@Service
public class SoftwaresCatagoryServiceImpl implements SoftwaresCatagoryService {
	@Autowired
	private SoftwaresCatagoryRepository softwaresCatagoryRepository;

	@Override
	public List<SoftwaresCatagory> getAllSoftwaresCatagory() {
		// TODO Auto-generated method stub
		return softwaresCatagoryRepository.findAll();
	}

	@Override
	public Optional<SoftwaresCatagory> getSoftwaresCatagoryById(Long id) {
		// TODO Auto-generated method stub
		return softwaresCatagoryRepository.findById(id);
	}

	@Override
	public SoftwaresCatagory createSoftwareCatagory(SoftwaresCatagory softwaresCatagory) {
		// TODO Auto-generated method stub
		return softwaresCatagoryRepository.save(softwaresCatagory);
	}

	@Override
	public SoftwaresCatagory updateSoftwaresCatagory(Long id, SoftwaresCatagory softwaresCatagoryDetails) {
		// TODO Auto-generated method stub
		Optional<SoftwaresCatagory> softwaresCatagory = softwaresCatagoryRepository.findById(id);
		if (softwaresCatagory.isPresent()) {
			SoftwaresCatagory updatedSoftwaresCatagory = softwaresCatagory.get();
			updatedSoftwaresCatagory.setName(softwaresCatagoryDetails.getName());
			updatedSoftwaresCatagory.setDescription(softwaresCatagoryDetails.getDescription());
			return softwaresCatagoryRepository.save(updatedSoftwaresCatagory);

		} else {
			return null;
		}
	}

	@Override
	public void deleteSoftwaresCatagory(long id) {
		// TODO Auto-generated method stub
		Optional<SoftwaresCatagory> softwaresCatagory = softwaresCatagoryRepository.findById(id);
		softwaresCatagory.ifPresent(softwaresCatagoryRepository::delete);
	}

}
