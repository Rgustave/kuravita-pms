package com.kuravita.inventorymanagementservice.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.kuravita.inventorymanagementservice.databasemodels.Category;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Integer>{

}
