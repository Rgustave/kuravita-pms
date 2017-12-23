package com.kuravita.inventorymanagementservice.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.kuravita.inventorymanagementservice.model.Category;

@Repository
@RepositoryRestResource(collectionResourceRel = "categories", path = "categories")
public interface CategoryRepository extends CrudRepository<Category, Long>{
	
	/**
	 * Lookup a category by the name
	 * @param name
	 * @return
	 */
	Category findByName(@Param("name")String name);
	
	//Not exposed by Spring Data REST
    @Override
    @RestResource(exported = false)
    <S extends Category> S save(S s);

    //Not exposed by Spring Data REST
    @Override
    @RestResource(exported = false)
    <S extends Category> Iterable<S> save(Iterable<S> iterable);

    //Not exposed by Spring Data REST
    @Override
    @RestResource(exported = false)
    void delete(Long i);

    //Not exposed by Spring Data REST
    @Override
    @RestResource(exported = false)
    void delete(Category category);

    //Not exposed by Spring Data REST
    @Override
    @RestResource(exported = false)
    void delete(Iterable<? extends Category> iterable);

    //Not exposed by Spring Data REST
    @Override
    @RestResource(exported = false)
    void deleteAll();
}
