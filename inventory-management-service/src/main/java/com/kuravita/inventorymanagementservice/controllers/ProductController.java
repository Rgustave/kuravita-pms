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

import com.kuravita.inventorymanagementservice.databasemodels.Product;
import com.kuravita.inventorymanagementservice.repositories.ProductRepository;

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
		private ProductRepository proRepo;
		
		/**
		 * Create
		 * @param Product
		 * @return
		 */
		@PostMapping("/save")
		public Product saveProduct(@Valid @RequestBody Product Product) {
			return proRepo.save(Product);
		}
		
		/**
		 * read all
		 * @return
		 */
		@GetMapping("/getAll")
		public Iterable<Product> getAllProducts(){
			return proRepo.findAll();
		}
		
		/**
		 * Get one by name
		 * @param ProductName
		 * @return
		 */
		@GetMapping("/getOne/{name}")
		public ResponseEntity<Product> getProductById(@PathVariable(value = "name") String ProductName){
			Product pro = proRepo.findByName(ProductName);
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
		public ResponseEntity<Product> updateProduct(@PathVariable(value = "name") String proName, 
		                                       @Valid @RequestBody Product pro) {
		    Product Product = proRepo.findByName(proName);
		    if(Product == null) {
		        return ResponseEntity.notFound().build();
		    }
		    Product.setName(pro.getName());
		    Product.setDescription(pro.getDescription());
		    Product.setCategory(pro.getCategory());
		    
		    Product updatedProduct = proRepo.save(Product);
		    return ResponseEntity.ok(updatedProduct);
		}
		
		/**
		 * Delete one
		 * @param proName
		 * @return
		 */
		@DeleteMapping("/deleteOne/{name}")
		public ResponseEntity<Product> deleteProduct(@PathVariable(value = "name") String proName) {
		    Product Product = proRepo.findByName(proName);
		    if(Product == null) {
		        return ResponseEntity.notFound().build();
		    }

		    proRepo.delete(Product);
		    return ResponseEntity.ok().build();
		}
}
