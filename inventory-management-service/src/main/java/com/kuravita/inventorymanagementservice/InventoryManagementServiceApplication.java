
package com.kuravita.inventorymanagementservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kuravita.inventorymanagementservice.service.PackageTypeService;
@EnableDiscoveryClient
@SpringBootApplication
@RestController
@ComponentScan
public class InventoryManagementServiceApplication implements CommandLineRunner {
	
	@Autowired
	private PackageTypeService packageTypeService;
	

	public static void main(String[] args) {
		SpringApplication.run(InventoryManagementServiceApplication.class, args);				
	}
	
	@RequestMapping("/")
	public String message() {
		//return "Hello From :" + instance;
		return "Hello From : inventoryManagementService";
	}

	@Override
	public void run(String... arg0) throws Exception {
		// Create the Default  Package Types to mock the H2 DB
		packageTypeService.createPackageType("Carton Box", "Small Box");
		packageTypeService.createPackageType("Carton Box", "Small Box2");
		packageTypeService.createPackageType("Carton Box", "Small Box3");
		packageTypeService.createPackageType("Carton Box", "Small Box4");
		packageTypeService.createPackageType("Carton Box", "Small Box5");
		packageTypeService.createPackageType("Carton Box", "Small Box5");
		packageTypeService.createPackageType("Carton Box", "Small Box5");
	}
}
