package com.kuravita.inventorymanagementservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import com.kuravita.inventorymanagementservice.model.CurrentInventory;


@RepositoryRestResource(collectionResourceRel = "currentInventories", path = "inventories")
public interface CurrentInventoryRepository extends JpaRepository<CurrentInventory, Long> {

	

}
