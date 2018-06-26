package com.kuravita.inventorymanagementservice.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;
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

import lombok.Data;

@Data
@Entity
public class PharmacyInventory implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5564732271713384558L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int pharmacyInventoryId;
	
	@Column
	private int quantity;
	@Column
	private int quantityIn;
	
	@Column
	private int quantityOut;
	@Column
	private int maxLevel;
	
	@Column
	private int minLevel;
	
	@Column
	private String changeReason;
	
	@Column
	private Date expirationDate;
	
	
	@Column
	private Date dateCreated;
	/**
	 * TODO to implement it so that it calls the user from  security service
	 */
	@Column
	private int creatorId;
	
	/**
	 * TODO to implement it so that it calls the Store 
	 */
	@Column
	private int storeID;
	
	
	@OneToMany(mappedBy = "pharmacyInventory", cascade = CascadeType.ALL, fetch = FetchType.LAZY) // owner of the relationship.
	private Set<PharmacyInventoryOutgoing> pharmacyInventoryOutgoings;
	
	
	@OneToMany(mappedBy = "pharmacyInventory", cascade = CascadeType.ALL, fetch = FetchType.LAZY) // owner of the relationship.
	private Set<PharmacyInventoryIncoming> pharmacyInventoryIncomings;
	
	
	private int pharmacyProductId;
	
	
	@JoinColumn(name = "supplierId")
	private Supplier supplierId;
	
	@JoinColumn(name = "transactionId")
	private PharmacyTransaction transactionId;
	
	
	@Column
	private int deliveryNos;



	
	
	
	
	
	
	

}
