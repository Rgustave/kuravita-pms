package com.kuravita.inventorymanagementservice.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kuravita.inventorymanagementservice.databasemodels.Category;
import com.kuravita.inventorymanagementservice.repositories.CategoryRepository;

/**
 * This class is responsible of connecting the category to the outside world.
 * @author rene.moise.kwibuka
 *
 */
@CrossOrigin		//Enabling Cross Origin Requests for a RESTful Web Service
@Controller    // This means that this class is a RestController
@RequestMapping(path="/api")
public class CategoryController {
	@Autowired
	private CategoryRepository catRepo;
	
	//Create
	@PostMapping("/category")
	public Category saveCategory(@Valid @RequestBody Category category) {
		return catRepo.save(category);
	}
	
	/**
	 * Read
	 */
	//read all
	@GetMapping("/categories")
	public Iterable<Category> getAllCategories(){
		return catRepo.findAll();
	}
	
	//Get one by Id
	@GetMapping("/category/{id}")
	public ResponseEntity<Category> getCategoryById(@PathVariable(value = "id") Integer categoryId){
		Category cat = catRepo.findOne(categoryId);
		if(cat == null)
			return ResponseEntity.notFound().build();
		return ResponseEntity.ok().body(cat);
	}
	
	//Update
	@PutMapping("/notes/{id}")
	public ResponseEntity<Category> updateNote(@PathVariable(value = "id") Integer catId, 
	                                       @Valid @RequestBody Category cat) {
	    Category category = catRepo.findOne(catId);
	    if(category == null) {
	        return ResponseEntity.notFound().build();
	    }
	    category.setIdCategory(cat.getIdCategory());
	    category.setDescription(cat.getDescription());

	    Category updatedCategoty = catRepo.save(category);
	    return ResponseEntity.ok(updatedCategoty);
	}
	
	//Delete
	@DeleteMapping("/Category/{id}")
	public ResponseEntity<Category> deleteNote(@PathVariable(value = "id") Integer catId) {
	    Category category = catRepo.findOne(catId);
	    if(category == null) {
	        return ResponseEntity.notFound().build();
	    }

	    catRepo.delete(category);
	    return ResponseEntity.ok().build();
	}
}
