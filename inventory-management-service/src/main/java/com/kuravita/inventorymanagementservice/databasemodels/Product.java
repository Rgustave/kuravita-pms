package com.kuravita.inventorymanagementservice.databasemodels;

import java.util.HashSet;
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
import javax.validation.constraints.NotNull;

import org.json.JSONObject;

/**
 * This class models a product. A product can be something like amoxicillin.
 * @author rene.moise.kwibuka
 *
 */
@Entity
public class Product {
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	Integer idProduct;
	@NotNull
	@Column(unique=true)
	private String name;
	private String description;
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idCategory")
    private Category category;
	
	@OneToMany(fetch = FetchType.EAGER,  cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name="product_id")
	private Set<CurrentInventory> currentInventory = new HashSet<CurrentInventory>();
	
	public Integer getIdProduct() {
		return idProduct;
	}
	public void setIdProduct(Integer idProduct) {
		this.idProduct = idProduct;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	
	public Set<CurrentInventory> getCurrentInventory() {
		return currentInventory;
	}
	public void setCurrentInventory(Set<CurrentInventory> currentInventory) {
		this.currentInventory = currentInventory;
	}
	public String toString(){
    		String jsonText = "";
    		try {
    			//TODO: Jackson spring boot
	        JSONObject proJsonObject = new JSONObject();
	        proJsonObject.put("name",this.name);
	        proJsonObject.put("description", this.getDescription());
	        proJsonObject.put("idProduct", this.getIdProduct());
	        
	        JSONObject catJsonObj = new JSONObject();
	        catJsonObj.put("name", this.category.getName());
	        catJsonObj.put("description", this.category.getDescription());
	        proJsonObject.put("category", catJsonObj);
	        
	        jsonText = proJsonObject.toString();
    		}
    		catch (Exception e) {
			e.printStackTrace();
		}
        return jsonText;
    }
}
