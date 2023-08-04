package com.SoftwareInventory.SoftwareInventory.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SoftwareInventory.SoftwareInventory.entity.SoftwarePlatform;

import com.SoftwareInventory.SoftwareInventory.repository.PlatformRepository;
import com.SoftwareInventory.SoftwareInventory.service.SoftwaresPlatformService;

@Service
public class SoftwarePlatformServiceImpl implements SoftwaresPlatformService {

	@Autowired
	private PlatformRepository platformRepository;

	@Override
	public List<SoftwarePlatform> getAllPlatforms() {
		// TODO Auto-generated method stub
		return platformRepository.findAll();
	}

	@Override
	public Optional<SoftwarePlatform> getPlateformById(Long id) {
		// TODO Auto-generated method stub
		return platformRepository.findById(id);
	}

	@Override
	public SoftwarePlatform createPlatform(SoftwarePlatform softwarePlatform) {
		// TODO Auto-generated method stub
		return platformRepository.save(softwarePlatform);
	}

	@Override
	public SoftwarePlatform updateSoftwaresPlatform(Long id, SoftwarePlatform softwarePlatformDetails) {
		Optional<SoftwarePlatform> softwaresplatform = platformRepository.findById(id);
		if (softwaresplatform.isPresent()) {
			SoftwarePlatform updatedSoftwaresPlatform = softwaresplatform.get();
			updatedSoftwaresPlatform.setPlatform(softwarePlatformDetails.getPlatform());
			updatedSoftwaresPlatform.setOperatingsystem(softwarePlatformDetails.getOperatingsystem());
			return platformRepository.save(updatedSoftwaresPlatform);

		} else {
			return null;
		}
	}

	@Override
	public void deletePlateform(long id) {
		// TODO Auto-generated method stub
		Optional<SoftwarePlatform> softwaresPlatform = platformRepository.findById(id);
		softwaresPlatform.ifPresent(platformRepository::delete);
	}

}
