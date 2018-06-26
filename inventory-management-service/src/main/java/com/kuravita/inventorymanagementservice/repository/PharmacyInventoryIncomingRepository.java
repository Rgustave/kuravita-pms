/**
 * 
 */
package com.kuravita.inventorymanagementservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import com.kuravita.inventorymanagementservice.model.PharmacyInventory;
import com.kuravita.inventorymanagementservice.model.PharmacyInventoryIncoming;

/**
 * @author gustave.mugabo
 *
 */

@RepositoryRestResource(collectionResourceRel = "pharmacyInventoryIncomings", path = "incomingInventories")
public interface PharmacyInventoryIncomingRepository extends JpaRepository<PharmacyInventoryIncoming, Integer>{

	
	//Not exposed by Spring Data REST
    @RestResource(exported = false)
    <S extends PharmacyInventory> S save(S s);

    //Not exposed by Spring Data REST
    @Override
    @RestResource(exported = false)
    <S extends PharmacyInventoryIncoming> List<S> save(Iterable<S> iterable);

    //Not exposed by Spring Data REST
    @Override
    @RestResource(exported = false)
    void delete(Integer s);

    //Not exposed by Spring Data REST
    @Override
    @RestResource(exported = false)
    void delete(PharmacyInventoryIncoming pharmacyInventory);

    //Not exposed by Spring Data REST
    @Override
    @RestResource(exported = false)
    void delete(Iterable<? extends PharmacyInventoryIncoming> iterable);

    //Not exposed by Spring Data REST
    @Override
    @RestResource(exported = false)
    void deleteAll();
	
}
