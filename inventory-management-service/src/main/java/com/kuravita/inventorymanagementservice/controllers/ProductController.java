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

import com.kuravita.inventorymanagementservice.model.PharmacyProduct;
import com.kuravita.inventorymanagementservice.repository.PharmacyProductRepository;

/**
 * This class is responsible of connecting the product entity to the outside world.
 * @author rene.moise.kwibuka
 *
 */
@CrossOrigin		//Enabling Cross Origin Requests for a RESTful Web Service
@RestController    // This means that this class is a RestController
@RequestMapping(path="/product")
public class ProductController {
		
		@Autowired
		private PharmacyProductRepository proRepo;
		
		/**
		 * Create
		 * @param Product
		 * @return
		 */
		@PostMapping("/save")
		public PharmacyProduct savePharmacyProduct(@Valid @RequestBody PharmacyProduct pharmacyProduct) {
			return proRepo.save(pharmacyProduct);
		}
		
		/**
		 * read all
		 * @return
		 */
		@GetMapping("/getAll")
		public Iterable<PharmacyProduct> getAllProducts(){
			return proRepo.findAll();
		}
		
		/**
		 * Get one by name
		 * @param ProductName
		 * @return
		 */
		@GetMapping("/getOne/{name}")
		public ResponseEntity<PharmacyProduct> getProductById(@PathVariable(value = "name") String ProductName){
			PharmacyProduct pro = proRepo.findByName(ProductName);
			if(pro == null)
				return ResponseEntity.notFound().build();
			return ResponseEntity.ok().body(pro);
		}
		
		/**
		 * Update one
		 * @param proName
		 * @param pro
		 * @return
		 */
		@PutMapping("/updateOne/{name}")
		public ResponseEntity<PharmacyProduct> updateProduct(@PathVariable(value = "name") String proName, 
		                                       @Valid @RequestBody PharmacyProduct pro) {
			PharmacyProduct Product = proRepo.findByName(proName);
		    if(Product == null) {
		        return ResponseEntity.notFound().build();
		    }
		    Product.setName(pro.getName());
		    Product.setDescription(pro.getDescription());
		    Product.setCategory(pro.getCategory());
		    
		    PharmacyProduct updatedProduct = proRepo.save(Product);
		    return ResponseEntity.ok(updatedProduct);
		}
		
		/**
		 * Delete one
		 * @param proName
		 * @return
		 */
		@DeleteMapping("/deleteOne/{name}")
		public ResponseEntity<PharmacyProduct> deleteProduct(@PathVariable(value = "name") String proName) {
			PharmacyProduct Product = proRepo.findByName(proName);
		    if(Product == null) {
		        return ResponseEntity.notFound().build();
		    }

		    proRepo.delete(Product);
		    return ResponseEntity.ok().build();
		}
}
