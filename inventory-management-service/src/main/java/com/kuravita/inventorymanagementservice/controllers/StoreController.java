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

import com.kuravita.inventorymanagementservice.model.Store;
import com.kuravita.inventorymanagementservice.repository.StoreRepository;

/**
 * This class is responsible of connecting the store entity to the outside world.
 * @author rene.moise.kwibuka
 *
 */
@CrossOrigin		//Enabling Cross Origin Requests for a RESTful Web Service
@RestController    // This means that this class is a RestController
@RequestMapping(path="/store")
public class StoreController {
	@Autowired
	private StoreRepository stoRepo;
	
	/**
	 * save store
	 * @param store
	 * @return
	 */
	@PostMapping("/save")
	public Store saveStore(@Valid @RequestBody Store store) {
		return stoRepo.save(store);
	}
	
	/**
	 * Get All
	 * @return
	 */
	@GetMapping("/getAll")
	public Iterable<Store> getAllStores(){
		return stoRepo.findAll();
	}
	
	/**
	 * Get one
	 * @param storeName
	 * @return
	 */
	@GetMapping("/getOne/{name}")
	public ResponseEntity<Store> getStoreById(@PathVariable(value = "name") String storeName){
		Store sto = stoRepo.findByName(storeName);
		if(sto == null)
			return ResponseEntity.notFound().build();
		return ResponseEntity.ok().body(sto);
	}
	
	/**
	 * Update one
	 * @param stoName
	 * @param sto
	 * @return
	 */
	@PutMapping("/updateOne/{name}")
	public ResponseEntity<Store> updateStore(@PathVariable(value = "name") String stoName, 
	                                       @Valid @RequestBody Store sto) {
	    Store Store = stoRepo.findByName(stoName);
	    if(Store == null) {
	        return ResponseEntity.notFound().build();
	    }
	    Store.setName(sto.getName());
	    Store.setLogo(sto.getLogo());
	    Store.setAddress(sto.getAddress());	    
	    Store updatedStore = stoRepo.save(Store);
	    return ResponseEntity.ok(updatedStore);
	}
	
	/**
	 * Delete one
	 * @param stoName
	 * @return
	 */
	@DeleteMapping("/deleteOne/{name}")
	public ResponseEntity<Store> deleteStore(@PathVariable(value = "name") String stoName) {
	    Store Store = stoRepo.findByName(stoName);
	    if(Store == null) {
	        return ResponseEntity.notFound().build();
	    }

	    stoRepo.delete(Store);
	    return ResponseEntity.ok().build();
	}
}
