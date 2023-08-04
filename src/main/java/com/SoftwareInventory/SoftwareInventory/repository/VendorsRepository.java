package com.SoftwareInventory.SoftwareInventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.SoftwareInventory.SoftwareInventory.entity.SoftwaresVendor;

public interface VendorsRepository extends JpaRepository<SoftwaresVendor, Long>{

}
