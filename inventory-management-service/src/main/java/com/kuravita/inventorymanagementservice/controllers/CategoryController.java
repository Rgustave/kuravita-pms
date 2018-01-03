package com.kuravita.inventorymanagementservice.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kuravita.inventorymanagementservice.databasemodels.Category;
import com.kuravita.inventorymanagementservice.repositories.CategoryRepository;

/**
 * This class is responsible of connecting the category to the outside world.
 * @author rene.moise.kwibuka
 *
 */
@CrossOrigin		//Enabling Cross Origin Requests for a RESTful Web Service
@RestController    // This means that this class is a RestController
@RequestMapping(path="/category")
public class CategoryController {
	@Autowired
	private CategoryRepository catRepo;
	
	/**
	 * Save new category
	 * @param category
	 * @return
	 */
	@PostMapping("/save")
	public Category saveCategory(@Valid @RequestBody Category category) {
		return catRepo.save(category);
	}
	
	/**
	 * read all
	 * @return
	 */
	@GetMapping("/getAll")
	public Iterable<Category> getAllCategories(){
		return catRepo.findAll();
	}
	
	/**
	 * Get one by name
	 * @param categoryName
	 * @return
	 */
	@GetMapping("/getOne/{name}")
	public ResponseEntity<Category> getCategoryById(@PathVariable(value = "name") String categoryName){
		Category cat = catRepo.findByName(categoryName);
		if(cat == null)
			return ResponseEntity.notFound().build();
		return ResponseEntity.ok().body(cat);
	}
	
	/**
	 * Update one
	 * @param catName
	 * @param cat
	 * @return
	 */
	@PutMapping("/updateOne/{name}")
	public ResponseEntity<Category> updateCategory(@PathVariable(value = "name") String catName, 
	                                       @Valid @RequestBody Category cat) {
	    Category category = catRepo.findByName(catName);
	    if(category == null) {
	        return ResponseEntity.notFound().build();
	    }
	   
	    category.setName(cat.getName());
	    category.setDescription(cat.getDescription());
	    category.setProducts(cat.getProducts());
	    Category updatedCategory = catRepo.save(category);
	    
	    return ResponseEntity.ok(updatedCategory);
	}
	
	/**
	 * Delete one
	 * @param catName
	 * @return
	 */
	@DeleteMapping("/deleteOne/{name}")
	public ResponseEntity<Category> deleteCategory(@PathVariable(value = "name") String catName) {
	    Category category = catRepo.findByName(catName);
	    if(category == null) {
	        return ResponseEntity.notFound().build();
	    }

	    catRepo.delete(category);
	    return ResponseEntity.ok().build();
	}
}
