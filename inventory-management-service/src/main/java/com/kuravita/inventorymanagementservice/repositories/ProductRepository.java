package com.kuravita.inventorymanagementservice.repositories;

import org.springframework.data.repository.CrudRepository;

import com.kuravita.inventorymanagementservice.databasemodels.Product;

public interface ProductRepository extends CrudRepository<Product, Integer>{

}
