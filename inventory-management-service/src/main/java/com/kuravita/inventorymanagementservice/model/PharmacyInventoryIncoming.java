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

import lombok.Data;

@Data
@Entity
public class PharmacyInventoryIncoming implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5564732271713384558L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int pharmacyInventoryOutgoingId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "pharmacyProductId")
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
	@JoinColumn(name = "UserId")

	private User creatorId;

	@Column
	@JoinColumn(name = "storeId")
	private Store storeID;

	@JoinColumn(name = "supplierId")
	@ManyToOne(fetch = FetchType.EAGER)
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
	 * @param maxLevel
	 * @param minLevel
	 * @param expirationDate
	 * @param dateCreated
	 * @param creatorId
	 * @param transactionId
	 */
	public PharmacyInventoryIncoming(PharmacyProduct pharmacyProductId, int quantity, int quanitityIn, int maxLevel,
			int minLevel, Date expirationDate, Date dateCreated, User creatorId, PharmacyTransaction transactionId) {
		super();
		this.pharmacyProductId = pharmacyProductId;
		this.quantity = quantity;
		this.quanitityIn = quanitityIn;
		this.maxLevel = maxLevel;
		this.minLevel = minLevel;
		this.expirationDate = expirationDate;
		this.dateCreated = dateCreated;
		this.creatorId = creatorId;
		this.transactionId = transactionId;
	}

	
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
	 * @param deliveryNos
	 */
	public PharmacyInventoryIncoming(PharmacyProduct pharmacyProductId, int quantity, int quanitityIn, int quanitityOut,
			int maxLevel, int minLevel, String changeReason, Date expirationDate, Date dateCreated, User creatorId,
			Store storeID, Supplier supplierId, PharmacyTransaction transactionId, int deliveryNos) {
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
		this.deliveryNos = deliveryNos;
	}

}
