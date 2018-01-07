package com.kuravita.pricemanagementservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
@EnableDiscoveryClient
@SpringBootApplication
@RestController
public class PriceManagementServiceApplication {
	@Autowired
	private EurekaClient client;

	@Autowired
	private RestTemplateBuilder restTemplateBuilder;  
	public static void main(String[] args) {
		SpringApplication.run(PriceManagementServiceApplication.class, args);
	}
	
	
	/**
	 * This is a simple implimentation of how our service will be calling each other.
	 * Will move all the controller related into it own controller inorder to keep the good code structure
	 * 
	 * @return response from the called Service
	 */
	@RequestMapping("/")
	public String callInventoryManagementServiceBaseUrl() {
		RestTemplate restTemplate =  restTemplateBuilder.build();
		InstanceInfo instanceInfo =client.getNextServerFromEureka("inventory-management-service", false);
		String baseUrl = instanceInfo.getHomePageUrl();
		ResponseEntity<String> response = restTemplate.exchange(baseUrl, HttpMethod.GET,null,String.class);
		return "From pricingManagementService "+response.getBody();
		
	}
	
	

}
