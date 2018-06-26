/**
 * 
 */
package com.kuravita.inventorymanagementservice.service;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.BadRequestException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kuravita.inventorymanagementservice.model.PharmacyInventory;
import com.kuravita.inventorymanagementservice.model.PharmacyProduct;
import com.kuravita.inventorymanagementservice.model.ProductDetails;
import com.kuravita.inventorymanagementservice.repository.PharmacyInventoryRepository;
import com.kuravita.inventorymanagementservice.repository.PharmacyProductRepository;
import com.kuravita.inventorymanagementservice.utils.InventoryMsUtils;

/**
 * @author gustave.mugabo
 *
 */
@Service
public class PharmacyInventoryService {

	private PharmacyInventoryRepository pharmacyInventoryRepository;
	private PharmacyProductRepository pharmacyProductRepo;

	@Autowired
	public PharmacyInventoryService(PharmacyInventoryRepository pharmacyInventoryRepository,
			PharmacyProductRepository pharmacyProductRepo) {
		this.pharmacyInventoryRepository = pharmacyInventoryRepository;
		this.pharmacyProductRepo = pharmacyProductRepo;
	}

	/**
	 * Create a new pharmacyInventory
	 * 
	 * @param pharmacyInventory
	 * @return
	 */

	public PharmacyInventory createPharmacyInventory(PharmacyInventory pharmacyInventory) {
		if (InventoryMsUtils.nonNull(pharmacyInventory)) {

			if (InventoryMsUtils.isNull(pharmacyInventoryRepository
					.findByPharmacyInventoryId(pharmacyInventory.getPharmacyInventoryId()))) {
				return pharmacyInventoryRepository.save(pharmacyInventory);
			} else {
				throw new BadRequestException("PharmacyInventory Element already exist in the database");
			}

		}

		return null;
	}

	/**
	 * Get product available product details per store
	 * 
	 * @param pharmcyProduct
	 * @param storeId
	 * @return
	 */

	public List<ProductDetails> getCurrentProductsInventory(PharmacyProduct pharmcyProduct, int storeId) {

		if (InventoryMsUtils.nonNull(pharmcyProduct)) {
			if (InventoryMsUtils
					.nonNull(pharmacyInventoryRepository.findByPharmacyProductIdAndStoreID(
							pharmcyProduct.getPharmacyProductPharmacyProductId(), storeId))
					&& pharmacyInventoryRepository.findByPharmacyProductIdAndStoreID(
							pharmcyProduct.getPharmacyProductPharmacyProductId(), storeId).size() > 0) {

				return populateProductDetails(pharmacyInventoryRepository.findByPharmacyProductIdAndStoreID(
						pharmcyProduct.getPharmacyProductPharmacyProductId(), storeId));

			}

		}
		return null;

	}

	/**
	 * Beautify the product details 
	 * @param currentProductsInInventory
	 * @return
	 */
	private List<ProductDetails> populateProductDetails(List<PharmacyInventory> currentProductsInInventory) {
		List<ProductDetails> productDetailsList = new ArrayList<>();
		currentProductsInInventory.stream().forEach(productInInventory -> {
			PharmacyProduct pharmacyProduct = pharmacyProductRepo
					.findByPharmacyProductPharmacyProductId(productInInventory.getPharmacyProductId());
			ProductDetails productDetails = new ProductDetails();
			productDetails.setExpirationDate(productInInventory.getExpirationDate());
			productDetails.setProductName(pharmacyProduct.getName());
			productDetails.setQuantity(productInInventory.getQuantity());
			productDetails.setProductDetailsUUID(pharmacyProduct.getPharmacyProductPharmacyProductId());
			productDetailsList.add(productDetails);
		});

		return productDetailsList;
	}
	
	

	
	
}
