package com.kuravita.inventorymanagementservice.databasemodels;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

/**
 * This class models a store. A store example can be Kipharma Pharmacy.
 * @author rene.moise.kwibuka
 *
 */
@Entity
@Data
public class Store {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer idStore;
	private String name;
	private String logo;
	private String address;
}
