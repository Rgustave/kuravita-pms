package com.kuravita.inventorymanagementservice.databasemodels;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
