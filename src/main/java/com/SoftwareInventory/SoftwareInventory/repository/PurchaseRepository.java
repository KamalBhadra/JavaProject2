package com.SoftwareInventory.SoftwareInventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.SoftwareInventory.SoftwareInventory.entity.Purchase;

public interface PurchaseRepository extends JpaRepository<Purchase, Long>{

}
