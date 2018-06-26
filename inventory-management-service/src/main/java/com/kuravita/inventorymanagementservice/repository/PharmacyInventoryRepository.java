/**
 * 
 */
package com.kuravita.inventorymanagementservice.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.data.domain.Pageable;

import com.kuravita.inventorymanagementservice.model.PharmacyInventory;

/**
 * @author gustave.mugabo
 *
 */

@RepositoryRestResource(collectionResourceRel = "pharamacyInventories", path = "inventories")
public interface PharmacyInventoryRepository extends JpaRepository<PharmacyInventory, Integer> {
	
	
	
	List<PharmacyInventory> findByPharmacyProductIdAndStoreID(@Param("pharmacyProductId") int pharmacyProductId,@Param("storeID") int storeID);
    Page<PharmacyInventory> findByPharmacyInventoryId(Integer storeId, Pageable pageable);
    Page<PharmacyInventory> findByStoreIDOrderByExpirationDateAsc(Integer storeId);
    


	//Not exposed by Spring Data REST
    @RestResource(exported = false)
    <S extends PharmacyInventory> S save(S s);

    //Not exposed by Spring Data REST
    @Override
    @RestResource(exported = false)
    <S extends PharmacyInventory> List<S> save(Iterable<S> iterable);

    //Not exposed by Spring Data REST
    @Override
    @RestResource(exported = false)
    void delete(Integer s);

    //Not exposed by Spring Data REST
    @Override
    @RestResource(exported = false)
    void delete(PharmacyInventory pharmacyInventory);

    //Not exposed by Spring Data REST
    @Override
    @RestResource(exported = false)
    void delete(Iterable<? extends PharmacyInventory> iterable);

    //Not exposed by Spring Data REST
    @Override
    @RestResource(exported = false)
    void deleteAll();
	List<PharmacyInventory>  findByPharmacyInventoryId(int pharmacyInventoryId);
	
  
}
