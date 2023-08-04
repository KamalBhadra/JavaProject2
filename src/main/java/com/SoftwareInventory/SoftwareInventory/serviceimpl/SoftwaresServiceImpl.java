package com.SoftwareInventory.SoftwareInventory.serviceimpl;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.SoftwareInventory.SoftwareInventory.entity.Softwares;
import com.SoftwareInventory.SoftwareInventory.repository.SoftwareRepository;
import com.SoftwareInventory.SoftwareInventory.service.SoftwaresService;

@Service
public class SoftwaresServiceImpl implements SoftwaresService {
    @Autowired
    private SoftwareRepository softwarerepository;
    
	@Override
	public List<Softwares> getAllSoftwares() {
		// TODO Auto-generated method stub
		return softwarerepository.findAll();
	}

	@Override
	public Optional<Softwares> getSoftwaresById(Long id) {
		// TODO Auto-generated method stub
		return softwarerepository.findById(id);
	}

	@Override
	public Softwares createSoftware(Softwares softwares) {
		// TODO Auto-generated method stub
		return softwarerepository.save(softwares);
	}

	@Override
	public Softwares updateSoftwares(Long id, Softwares softwaresDetails) {
		// TODO Auto-generated method stub
		Optional<Softwares> softwares=softwarerepository.findById(id);
		if(softwares.isPresent()) {
			Softwares updatedSoftwares= softwares.get();
			updatedSoftwares.setName(softwaresDetails.getName());
			updatedSoftwares.setVersion(softwaresDetails.getVersion());
			updatedSoftwares.setPublisher(softwaresDetails.getPublisher());
			updatedSoftwares.setQuantity(softwaresDetails.getQuantity());
			return softwarerepository.save(updatedSoftwares);
			
		}
		else {
			return null;
		}
	}

	@Override
	public void deleteSoftware(long id) {
		// TODO Auto-generated method stub
		
		Optional<Softwares> softwares=softwarerepository.findById(id);
		softwares.ifPresent(softwarerepository::delete);
		
		
	}

	
}
