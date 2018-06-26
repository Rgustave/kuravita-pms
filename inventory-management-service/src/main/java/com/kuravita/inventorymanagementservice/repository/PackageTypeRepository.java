package com.kuravita.inventorymanagementservice.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.kuravita.inventorymanagementservice.model.PackageType;
/**
 * Package Type  Repository Interface
 * @author gustave.mugabo
 *
 */

@RepositoryRestResource(collectionResourceRel = "PackageTypes", path = "packagetypes")
public interface PackageTypeRepository extends CrudRepository<PackageType, Long> {
	
	
	PackageType findByName(@Param("name") String name);
	PackageType findByPackageTypeId(@Param("id") Long packageTypeId);


}
