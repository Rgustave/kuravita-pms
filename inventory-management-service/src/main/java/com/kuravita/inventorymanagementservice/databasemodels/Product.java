package com.kuravita.inventorymanagementservice.databasemodels;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * This class models a product. A product can be something like amoxicillin.
 * @author rene.moise.kwibuka
 *
 */
@Entity
public class Product {
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	Integer idProduct;
	private String name;
	private String description;
	public Integer getIdProduct() {
		return idProduct;
	}
	public void setIdProduct(Integer idProduct) {
		this.idProduct = idProduct;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
