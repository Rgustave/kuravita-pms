package com.kuravita.inventorymanagementservice.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;


/*
 * This class models a store specific product. 
    @author blessed.mununuzi
 */

@Entity
@Table(name="current_inventory")
public class CurrentInventory {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="current_inventory_id")
	@JsonProperty("CURRENT_INVENTORY_ID")
	private Long currentInventoryId;
	
	@Column(name = "upc", unique = true, nullable = false, length = 45)
	@JsonProperty("UPC")
	private String upc;
	
	@Column(name="checked_in_dt_tm")
	@JsonProperty("CHECKED_IN_DT_TM")
	private Date checkedInDtTm;
	
	@Column(name="checked_out_dt_tm")
	@JsonProperty("CHECKED_OUT_DT_TM")
	private Date checkedOutDtTm;
	
	@Column(name="expiration_dt_tm")
	@JsonProperty("EXPIRATION_DT_TM")
	private Date expirationDtTm;
	
	@JsonProperty("QUANTITY")
	private Integer quantity;
	
	@Column(name="default_packaging", length = 45)
	@JsonProperty("DEFAULTPACKAGING")
	private String defaultPackaging;
	
	@Column(name="smallest_packaging", length = 45)
	@JsonProperty("SMALLEST_PACKAGING")
	private String smallestPackaging;
	
	@JoinColumn(name="packageTypeId")
	@JsonProperty("PACKAGING_TYPE_ID")
	private Package packageType;
	
	@JoinColumn(name="productId")
	@JsonProperty("PRODUCT_ID")
	private Product product ;
	
	@JoinColumn(name="storeId")
	@JsonProperty("STORE_ID")
	private Store store;

	public Long getCurrentInventoryId() {
		return currentInventoryId;
	}

	public void setCurrentInventoryId(Long currentInventoryId) {
		this.currentInventoryId = currentInventoryId;
	}

	public String getUpc() {
		return upc;
	}

	public void setUpc(String upc) {
		this.upc = upc;
	}

	public Date getCheckedInDtTm() {
		return checkedInDtTm;
	}

	public void setCheckedInDtTm(Date checkedInDtTm) {
		this.checkedInDtTm = checkedInDtTm;
	}

	public Date getCheckedOutDtTm() {
		return checkedOutDtTm;
	}

	public void setCheckedOutDtTm(Date checkedOutDtTm) {
		this.checkedOutDtTm = checkedOutDtTm;
	}

	public Date getExpirationDtTm() {
		return expirationDtTm;
	}

	public void setExpirationDtTm(Date expirationDtTm) {
		this.expirationDtTm = expirationDtTm;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public String getDefaultPackaging() {
		return defaultPackaging;
	}

	public void setDefaultPackaging(String defaultPackaging) {
		this.defaultPackaging = defaultPackaging;
	}

	public String getSmallestPackaging() {
		return smallestPackaging;
	}

	public void setSmallestPackaging(String smallestPackaging) {
		this.smallestPackaging = smallestPackaging;
	}

	public Package getPackageType() {
		return packageType;
	}

	public void setPackageType(Package packageType) {
		this.packageType = packageType;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Store getStore() {
		return store;
	}

	public void setStore(Store store) {
		this.store = store;
	}

	

}
