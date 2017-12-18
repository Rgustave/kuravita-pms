package com.kuravita.inventorymanagementservice.databasemodels;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

/**
 * This class models a product category. A category can be something like
 * antibiotics.
 * @author rene.moise.kwibuka
 *
 */
@Entity
public class Category {
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Integer idCategory;
	@NotNull
	@Column(unique=true)
	private String name;
	private String description;
	
	public Integer getIdCategory() {
		return idCategory;
	}
	public void setIdCategory(Integer idCategory) {
		this.idCategory = idCategory;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
