package com.SoftwareInventory.SoftwareInventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.SoftwareInventory.SoftwareInventory.entity.Softwares;

public interface SoftwareRepository extends JpaRepository<Softwares, Long>{

	

}
