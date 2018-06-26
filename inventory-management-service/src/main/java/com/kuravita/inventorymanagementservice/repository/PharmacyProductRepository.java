package com.kuravita.inventorymanagementservice.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import com.kuravita.inventorymanagementservice.model.PharmacyProduct;

@RepositoryRestResource(collectionResourceRel = "pharmacyProducts", path = "pharmacyProducts")

public interface PharmacyProductRepository extends CrudRepository<PharmacyProduct, Integer>{
	/**
	 * Lookup a pharmacyProduct by the name
	 * @param name
	 * @return
	 */
	public PharmacyProduct findByName(@Param("name")String name);
	public PharmacyProduct findByPharmacyProductPharmacyProductId(@Param("pharmacyProductPharmacyProductId")int productId);
//	//Not exposed by Spring Data REST
//    @Override
//    @RestResource(exported = false)
//    <S extends PharmacyProduct> S save(S s);
//
//    //Not exposed by Spring Data REST
//    @Override
//    @RestResource(exported = false)
//    <S extends PharmacyProduct> Iterable<S> save(Iterable<S> iterable);
//
//    //Not exposed by Spring Data REST
//    @Override
//    @RestResource(exported = false)
//    void delete(Integer s);
//
//    //Not exposed by Spring Data REST
//    @Override
//    @RestResource(exported = false)
//    void delete(PharmacyProduct product);
//
//    //Not exposed by Spring Data REST
//    @Override
//    @RestResource(exported = false)
//    void delete(Iterable<? extends PharmacyProduct> iterable);
//
//    //Not exposed by Spring Data REST
//    @Override
//    @RestResource(exported = false)
//    void deleteAll();
	
}
