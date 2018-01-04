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

@Data
@Entity
public class PackageType implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3570673394353400617L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long packageTypeId;
	@Column
	private String name;
	@Column
	private String description;
	
	@OneToMany(mappedBy = "packageType",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private Set<CurrentInventory> inventories = new HashSet<>();
	
	/**
	 * 
	 * Construct the a PackageType instance
	 * @param name
	 * @param description
	 */
	public PackageType(String name, String description) {
		this.name = name;
		this.description = description;
	}

	public PackageType() {
		super();
	}
	
}
