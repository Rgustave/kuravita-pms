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
class PharmacyFrequency  implements Serializable  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8684696676368819715L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column()
	private Long pharmacyFrequencyId;
	
	private String pharmacyFrequencyName;
	
	private User creator;
	
	private String reason;
		
}
