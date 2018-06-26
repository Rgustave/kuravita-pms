/**
 * 
 */
package com.kuravita.inventorymanagementservice.model;

import java.io.Serializable;
import java.sql.Date;

import lombok.Data;

/**
 * Provide the details of a particular product
 * @author gustave.mugabo
 *
 */
@Data
public class ProductDetails implements Serializable {

	private static final long serialVersionUID = -541295765712848373L;

	private int productDetailsUUID;
	private String productName;
	private Date expirationDate;
	private String productCategory;
	private int quantity;
	private double price;

}
