package com.kuravita.inventorymanagementservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kuravita.inventorymanagementservice.model.PackageType;
import com.kuravita.inventorymanagementservice.repository.PackageTypeRepository;

/**
 * Package Type Service
 * @author gustave.mugabo
 *
 */
@Service
public class PackageTypeService {
	
	private PackageTypeRepository  packageTypeRepository;
	
	
	@Autowired
	public PackageTypeService(PackageTypeRepository packageTypeRepository) {
		this.packageTypeRepository = packageTypeRepository;
	}
	
	
	/**
	 * Create  PackageType and Persist it in the Database
	 * @param Description
	 * @param name
	 * @return
	 */
    public PackageType createPackageType(String Description, String name) {
        if (packageTypeRepository.findByName(name) == null) {
            return packageTypeRepository.save(new PackageType(name,Description));
        } else {
            return null;
        }
    }
    
    /**
     * Get All PackageTypes 
     * @return Iterable<PackageType>
     */
    public Iterable<PackageType> lookup(){
        return packageTypeRepository.findAll();
    }
    
    /**
     * Get the count of all type  PackageTypes present in the DB
     * @return actual total numb
     */
    
    public long total() {
        return packageTypeRepository.count();
    }
	

}
