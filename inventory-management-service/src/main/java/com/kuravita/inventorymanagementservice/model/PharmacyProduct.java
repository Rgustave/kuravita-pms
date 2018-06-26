package com.kuravita.inventorymanagementservice.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
public class PharmacyProduct implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 908436688620689508L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int pharmacyProductPharmacyProductId;
	@NotNull
	@Column(unique = true)
	
	private String name;
	
	private String description;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "categoryId")
	private Category category;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "pharmacyDoseId")
	private PharmacyDose pharmacyDose;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "pharmacyFrequencyId")
	private PharmacyFrequency pharmacyFrequency;
	

}
