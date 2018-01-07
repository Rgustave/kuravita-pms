package com.kuravita.inventorymanagementservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import com.kuravita.inventorymanagementservice.model.CurrentInventory;


@RepositoryRestResource(collectionResourceRel = "currentInventories", path = "inventories")
public interface CurrentInventoryRepository extends JpaRepository<CurrentInventory, Long> {

	//Not exposed by Spring Data REST
    @Override
    @RestResource(exported = false)
    <S extends CurrentInventory> S save(S s);

    //Not exposed by Spring Data REST
    @Override
    @RestResource(exported = false)
    <S extends CurrentInventory> List<S> save(Iterable<S> iterable);

    //Not exposed by Spring Data REST
    @Override
    @RestResource(exported = false)
    void delete(Long s);

    //Not exposed by Spring Data REST
    @Override
    @RestResource(exported = false)
    void delete(CurrentInventory store);

    //Not exposed by Spring Data REST
    @Override
    @RestResource(exported = false)
    void delete(Iterable<? extends CurrentInventory> iterable);

    //Not exposed by Spring Data REST
    @Override
    @RestResource(exported = false)
    void deleteAll();
	
	

}
