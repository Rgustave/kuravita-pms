package com.kuravita.inventorymanagementservice.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

/**
 * This class models a store. A store example can be Kipharma Pharmacy.
 * 
 * @author rene.moise.kwibuka
 *
 */
@Data
@Entity
public class Store implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -280679337379684747L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long storeId;
	@Column
	private String name;
	@Column
	private String logo;
	@Column
	private String address;

	@OneToMany(mappedBy = "store",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private Set<Inventory> inventories = new HashSet<>();

	
}
