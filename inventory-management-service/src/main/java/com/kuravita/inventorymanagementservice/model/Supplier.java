package com.kuravita.inventorymanagementservice.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Supplier  implements Serializable  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4306454262281836723L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int supplierId;

}
