package com.kuravita.inventorymanagementservice.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class PharmacyTransaction implements Serializable  {/**
	 * 
	 */
	private static final long serialVersionUID = 3118694012148369114L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int transactionId;
	
	@Column
	private String  name;
	
	@Column
	private int creatorId;
	
	@Column
	private Date dateCreated;
	
	@Column
	private String reason;
	

}
