package com.kuravita.inventorymanagementservice.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import lombok.Data;

/**
 * This class models a product category. A category can be something like
 * antibiotics.
 * 
 * @author rene.moise.kwibuka
 *
 */
@Data
@Entity
public class Category implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1668121590663570352L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long categoryId;
	@NotNull
	@Column(unique = true)
	private String name;
	@Column
	private String description;
	@OneToMany(mappedBy = "category", cascade = CascadeType.ALL, fetch = FetchType.LAZY) // owner of the relationship.
	private Set<PharmacyProduct> pharmacyProducts;
	

}
