package com.SoftwareInventory.SoftwareInventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.SoftwareInventory.SoftwareInventory.entity.SoftwarePlatform;

public interface PlatformRepository extends JpaRepository<SoftwarePlatform, Long> {

}
