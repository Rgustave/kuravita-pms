/**
 * 
 */
package com.kuravita.inventorymanagementservice.controllers;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.resource.ResourceServerProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.provider.token.ResourceServerTokenServices;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.kuravita.inventorymanagementservice.model.PharmacyInventory;
import com.kuravita.inventorymanagementservice.model.PharmacyProduct;
import com.kuravita.inventorymanagementservice.model.ProductDetails;
import com.kuravita.inventorymanagementservice.model.Store;
import com.kuravita.inventorymanagementservice.repository.PharmacyInventoryRepository;
import com.kuravita.inventorymanagementservice.repository.PharmacyProductRepository;
import com.kuravita.inventorymanagementservice.repository.StoreRepository;
import com.kuravita.inventorymanagementservice.service.CustomUserInfoTokenService;
import com.kuravita.inventorymanagementservice.service.PharmacyInventoryService;

/**
 * 
 * Pharmacy Inventory controller
 * 
 * @author gustave.mugabo
 *
 */
@RestController
@RequestMapping(path = "/v1")

public class PharmacyInventoryController {
	@Autowired
	PharmacyInventoryService pharmacyInventoryService;
	PharmacyInventoryRepository pharmacyInventoryRepository;
	PharmacyProductRepository pharmacyProductRepo;
	StoreRepository storeRepository;



	@Autowired
	public PharmacyInventoryController(PharmacyInventoryService pharmacyInventoryService,
			PharmacyInventoryRepository pharmacyInventoryRepository, PharmacyProductRepository pharmacyProductRepo,
			StoreRepository storeRepository) {
		this.pharmacyInventoryService = pharmacyInventoryService;
		this.pharmacyInventoryRepository = pharmacyInventoryRepository;
		this.pharmacyProductRepo = pharmacyProductRepo;
		this.storeRepository = storeRepository;
		;

	}

	protected PharmacyInventoryController() {

	}

	/**
	 * Create a Pharmacy Inventory
	 *
	 * 
	 * @param pharmacyInventory
	 */
	@PreAuthorize("#oauth2.hasScope('pharmacy_inventory') and hasRole('USER')")
	@PostMapping("/inventories")
	@ResponseStatus(HttpStatus.CREATED)
	public void createPharmacyInventory(@RequestBody @Validated PharmacyInventory pharmacyInventory) {
		pharmacyInventoryService.createPharmacyInventory(pharmacyInventory);
	}

	/**
	 * Lookup all products per for a particular store and return them by pages
	 * 
	 * @param storeid
	 * @param pageable
	 * @return List of Product details
	 */
	@PreAuthorize("#oauth2.hasScope('pharmacy_inventory') and hasRole('USER')")
	@GetMapping("/inventories/{storeid}")
	@ResponseStatus(HttpStatus.OK)
	public Page<ProductDetails> getAllProductForStore(@PathVariable(value = "storeid") int storeid, Pageable pageable) {
		Store store = verifyStore(storeid);
		Page<PharmacyInventory> pharmacyInventoryPage = pharmacyInventoryRepository.findByPharmacyInventoryId(storeid,
				pageable);

		List<ProductDetails> productDetailsList = pharmacyInventoryPage.getContent().stream()
				.map(pharmacyInventory -> toProductDetails(pharmacyInventory)).collect(Collectors.toList());

		return new PageImpl<ProductDetails>(productDetailsList, pageable, pharmacyInventoryPage.getTotalPages());

	}

	/**
	 * Convert list of pharmacyInventory into List of Product details
	 * 
	 * @param currentProductsInInventory
	 * @return
	 */

	private ProductDetails toProductDetails(PharmacyInventory productInInventory) {
		PharmacyProduct pharmacyProduct = pharmacyProductRepo
				.findByPharmacyProductPharmacyProductId(productInInventory.getPharmacyProductId());
		ProductDetails productDetails = new ProductDetails();
		productDetails.setExpirationDate(productInInventory.getExpirationDate());
		productDetails.setProductName(pharmacyProduct.getName());
		productDetails.setQuantity(productInInventory.getQuantity());
		productDetails.setProductDetailsUUID(pharmacyProduct.getPharmacyProductPharmacyProductId());

		return productDetails;
	}

	/**
	 * Verify and return the Store given a storeId.
	 *
	 * @param storeId
	 * @return the found store
	 * @throws NoSuchElementException
	 *             if no store found.
	 */
	private Store verifyStore(int storeId) throws NoSuchElementException {
		Store store = storeRepository.findOne(storeId);
		if (store == null) {
			throw new NoSuchElementException("Store does not exist " + storeId);
		}
		return store;
	}

	/**
	 * Exception handler if NoSuchElementException is thrown in this Controller
	 *
	 * @param ex
	 * @return Error message String.
	 */
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(NoSuchElementException.class)
	public String return400(NoSuchElementException ex) {
		return ex.getMessage();

	}
}
