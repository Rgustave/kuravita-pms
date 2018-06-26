/**
 * 
 */
package com.kuravita.inventorymanagementservice.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

/**
 * @author gustave.mugabo
 *
 */
@Data
@Entity
public class PharmacyDose implements Serializable {/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
   
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column()
	private Long pharmacyDoseId;
	
	private String pharmacyDoseName;
	
	private User creator;
	
	private String reason;
		
	
   
	
	
	
	
}
