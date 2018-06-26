/**
 * 
 */
package com.kuravita.inventorymanagementservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RestResource;

import com.kuravita.inventorymanagementservice.model.PharmacyInventory;
import com.kuravita.inventorymanagementservice.model.PharmacyInventoryOutgoing;

/**
 * @author gustave.mugabo
 *
 */
public interface PharmacyInventoryOutgoingRepository extends JpaRepository<PharmacyInventoryOutgoing, Integer> {

	//Not exposed by Spring Data REST
    @RestResource(exported = false)
    <S extends PharmacyInventory> S save(S s);

    //Not exposed by Spring Data REST
    @Override
    @RestResource(exported = false)
    <S extends PharmacyInventoryOutgoing> List<S> save(Iterable<S> iterable);

    //Not exposed by Spring Data REST
    @Override
    @RestResource(exported = false)
    void delete(Integer s);

    //Not exposed by Spring Data REST
    @Override
    @RestResource(exported = false)
    void delete(PharmacyInventoryOutgoing pharmacyInventory);

    //Not exposed by Spring Data REST
    @Override
    @RestResource(exported = false)
    void delete(Iterable<? extends PharmacyInventoryOutgoing> iterable);

    //Not exposed by Spring Data REST
    @Override
    @RestResource(exported = false)
    void deleteAll();
	
	
}
