
package com.kuravita.inventorymanagementservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableDiscoveryClient
@SpringBootApplication
@RestController
@ComponentScan
public class InventoryManagementServiceApplication {
	
	//@Value("${inventory-managent-service.instance.name}")
    //private String instance;
	
	public static void main(String[] args) {
		SpringApplication.run(InventoryManagementServiceApplication.class, args);				
	}
	
	@RequestMapping("/")
	public String message() {
		//return "Hello From :" + instance;
		return "Hello From : inventoryManagementService";
	}
}
