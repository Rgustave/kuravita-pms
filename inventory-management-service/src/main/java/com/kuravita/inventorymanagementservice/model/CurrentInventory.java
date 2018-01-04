package com.kuravita.inventorymanagementservice.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

/*
 * This class models a store specific product. 
    @author blessed.mununuzi
 */
@Data
@Entity
@Table(name = "current_inventory")
public class CurrentInventory implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 316318072113966424L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column()
	private Long currentInventoryId;

	@Column(unique = true, nullable = false, length = 45)
	private String upc;

	@Column()
	private Date checkedInDtTm;

	@Column()
	private Date checkedOutDtTm;

	@Column()
	private Date expirationDtTm;

	@Column()
	private Integer quantity;

	@Column(length = 45)
	private String defaultPackaging;

	@Column( length = 45)
	private String smallestPackaging;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "package_type_id")
	private PackageType packageType;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "product_id")
	private Product product;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "store_id")
	private Store store;

}
