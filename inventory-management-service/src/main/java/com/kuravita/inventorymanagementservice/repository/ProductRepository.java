package com.kuravita.inventorymanagementservice.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import com.kuravita.inventorymanagementservice.model.Product;

@RepositoryRestResource(collectionResourceRel = "products", path = "products")

public interface ProductRepository extends CrudRepository<Product, Long>{
	/**
	 * Lookup a product by the name
	 * @param name
	 * @return
	 */
	public Product findByName(@Param("name")String name);
	
	//Not exposed by Spring Data REST
    @Override
    @RestResource(exported = false)
    <S extends Product> S save(S s);

    //Not exposed by Spring Data REST
    @Override
    @RestResource(exported = false)
    <S extends Product> Iterable<S> save(Iterable<S> iterable);

    //Not exposed by Spring Data REST
    @Override
    @RestResource(exported = false)
    void delete(Long s);

    //Not exposed by Spring Data REST
    @Override
    @RestResource(exported = false)
    void delete(Product product);

    //Not exposed by Spring Data REST
    @Override
    @RestResource(exported = false)
    void delete(Iterable<? extends Product> iterable);

    //Not exposed by Spring Data REST
    @Override
    @RestResource(exported = false)
    void deleteAll();
	
}
