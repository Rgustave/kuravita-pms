package com.kuravita.inventorymanagementservice.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import com.kuravita.inventorymanagementservice.model.Store;
@RepositoryRestResource(collectionResourceRel = "stores", path = "stores")
public interface StoreRepository extends CrudRepository<Store, Integer>{
	/**
	 * Store lookup by name
	 * @param name
	 * @return
	 */
	public Store findByName(String name);
	
	
}
