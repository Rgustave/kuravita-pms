package com.kuravita.inventorymanagementservice.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.apache.commons.math.stat.descriptive.summary.Product;

import lombok.Data;
@Data
@Entity

public class PharmacyInventoryOutgoing implements Serializable  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6281435863571295815L;
	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int pharmacyInventoryOutgoingId;
	
	@JoinColumn(name = "pharmacyProductId")
	@ManyToOne(fetch = FetchType.EAGER)
	private PharmacyProduct pharmacyProductId;

	@Column
	private int quantity;
	@Column
	private int quanitityIn;
	
	@Column
	private int quanitityOut;
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

	@Column
	@JoinColumn(name = "userId")
	private User creatorId;
	
	@Column
	@JoinColumn(name = "storeID")
	private Store storeID;

	@JoinColumn(name = "supplierId")
	private Supplier supplierId;
	
	@JoinColumn(name = "transactionId")
	private PharmacyTransaction transactionId;
	
	@Column
	private int deliveryNos;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "pharmacyInventoryId")
	private PharmacyInventory pharmacyInventory;
	
	/**
	 * 
	 * @param pharmacyProductId
	 * @param quantity
	 * @param quanitityIn
	 * @param quanitityOut
	 * @param maxLevel
	 * @param minLevel
	 * @param changeReason
	 * @param expirationDate
	 * @param dateCreated
	 * @param creatorId
	 * @param storeID
	 * @param supplierId
	 * @param transactionId
	 */
	public PharmacyInventoryOutgoing(PharmacyProduct pharmacyProductId, int quantity, int quanitityIn, int quanitityOut, int maxLevel,
			int minLevel, String changeReason, Date expirationDate, Date dateCreated, User creatorId, Store storeID,
			Supplier supplierId, PharmacyTransaction transactionId) {
		super();
		this.pharmacyProductId = pharmacyProductId;
		this.quantity = quantity;
		this.quanitityIn = quanitityIn;
		this.quanitityOut = quanitityOut;
		this.maxLevel = maxLevel;
		this.minLevel = minLevel;
		this.changeReason = changeReason;
		this.expirationDate = expirationDate;
		this.dateCreated = dateCreated;
		this.creatorId = creatorId;
		this.storeID = storeID;
		this.supplierId = supplierId;
		this.transactionId = transactionId;
	}

	
	
	
}
