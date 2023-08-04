package com.SoftwareInventory.SoftwareInventory.serviceimpl;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.SoftwareInventory.SoftwareInventory.entity.SoftwaresUser;
import com.SoftwareInventory.SoftwareInventory.repository.SoftwaresUserRepository;
import com.SoftwareInventory.SoftwareInventory.service.SoftwaresUserService;

@Service
public class SoftwaresUserServiceImpl implements SoftwaresUserService{
    @Autowired
    private SoftwaresUserRepository softwaresUserRepository;
	@Override
	
	public List<SoftwaresUser> getAllSoftwaresUser() {
		// TODO Auto-generated method stub
		return softwaresUserRepository.findAll();
	}

	@Override
	public Optional<SoftwaresUser> getAllSoftwaresUserById(Long id) {
		// TODO Auto-generated method stub
		return softwaresUserRepository.findById(id);
	}

	@Override
	public SoftwaresUser createSoftwaresIUser(SoftwaresUser softwaresUser) {
		// TODO Auto-generated method stub
		return softwaresUserRepository.save(softwaresUser);
	}

	@Override
	public SoftwaresUser updateSoftwareUser(Long id, SoftwaresUser softwareUsersDetail) {
		// TODO Auto-generated method stub
		Optional<SoftwaresUser> softwaresuser=softwaresUserRepository.findById(id);
		if(softwaresuser.isPresent()) {
			SoftwaresUser updatedSoftwaresUser= softwaresuser.get();
			updatedSoftwaresUser.setSoftwareusername(softwareUsersDetail.getSoftwareusername());
			updatedSoftwaresUser.setSoftwarecatagory(softwareUsersDetail.getSoftwarecatagory());
			return softwaresUserRepository.save(updatedSoftwaresUser);
			
		}
		else {
			return null;
		}
	}

	@Override
	public void deleteSoftwaresUser(Long id) {
		Optional<SoftwaresUser> softwaresUser=softwaresUserRepository.findById(id);
		softwaresUser.ifPresent(softwaresUserRepository::delete);
		
	}

}
