package com.kuravita.inventorymanagementservice.repositories;

import org.springframework.data.repository.CrudRepository;

import com.kuravita.inventorymanagementservice.databasemodels.Store;

public interface StoreRepository extends CrudRepository<Store, String>{
	public Store findByName(String name);
}
