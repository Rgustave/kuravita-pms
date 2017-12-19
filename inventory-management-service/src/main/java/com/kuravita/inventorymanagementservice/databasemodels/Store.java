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

/**
 * This class models a store. A store example can be Kipharma Pharmacy.
 * @author rene.moise.kwibuka
 *
 */
@Entity
public class Store {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer idStore;
	private String name;
	private String logo;
	private String address;
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name="store_id")
    @JsonIgnore
    private Set<CurrentInventory> currentInventory = new HashSet<CurrentInventory>();
	
	public Set<CurrentInventory> getCurrentInventory() {
		return currentInventory;
	}
	public void setCurrentInventory(Set<CurrentInventory> currentInventory) {
		this.currentInventory = currentInventory;
	}
	
	public Integer getIdStore() {
		return idStore;
	}
	public void setIdStore(Integer idStore) {
		this.idStore = idStore;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLogo() {
		return logo;
	}
	public void setLogo(String logo) {
		this.logo = logo;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
}
