package com.kuravita.inventorymanagementservice.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import lombok.Data;

/**
 * This class models a product. A product can be something like amoxicillin.
 * 
 * @author rene.moise.kwibuka
 *
 */
@Data
@Entity
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long productId;
	@NotNull
	@Column(unique = true)
	private String name;
	private String description;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "categoryId")
	private Category category;

	@OneToMany(mappedBy ="product", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Set<Inventory> inventories = new HashSet<>();

}
