package com.kuravita.inventorymanagementservice.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import com.kuravita.inventorymanagementservice.model.Store;
@RepositoryRestResource(collectionResourceRel = "stores", path = "stores")
public interface StoreRepository extends CrudRepository<Store, Long>{
	/**
	 * Store lookup by name
	 * @param name
	 * @return
	 */
	public Store findByName(String name);
	
	
	//Not exposed by Spring Data REST
    @Override
    @RestResource(exported = false)
    <S extends Store> S save(S s);

    //Not exposed by Spring Data REST
    @Override
    @RestResource(exported = false)
    <S extends Store> Iterable<S> save(Iterable<S> iterable);

    //Not exposed by Spring Data REST
    @Override
    @RestResource(exported = false)
    void delete(Long s);

    //Not exposed by Spring Data REST
    @Override
    @RestResource(exported = false)
    void delete(Store store);

    //Not exposed by Spring Data REST
    @Override
    @RestResource(exported = false)
    void delete(Iterable<? extends Store> iterable);

    //Not exposed by Spring Data REST
    @Override
    @RestResource(exported = false)
    void deleteAll();
}
