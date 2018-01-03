package com.kuravita.inventorymanagementservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kuravita.inventorymanagementservice.databasemodels.CurrentInventory;

public interface CurrentInventoryRepository extends JpaRepository<CurrentInventory, Long> {

}
