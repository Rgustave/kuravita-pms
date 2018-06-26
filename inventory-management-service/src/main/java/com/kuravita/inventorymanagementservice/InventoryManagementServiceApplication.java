
package com.kuravita.inventorymanagementservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.resource.ResourceServerProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.provider.token.ResourceServerTokenServices;

import com.kuravita.inventorymanagementservice.service.CustomUserInfoTokenService;
import com.kuravita.inventorymanagementservice.service.PackageTypeService;



@SpringBootApplication
@EnableResourceServer
@EnableDiscoveryClient
@EnableOAuth2Client
@EnableFeignClients
@EnableGlobalMethodSecurity(prePostEnabled = true)
@ComponentScan
public class InventoryManagementServiceApplication implements CommandLineRunner {

	@Autowired
	private PackageTypeService packageTypeService;

	@Autowired
	private ResourceServerProperties sso;

	@Bean
	public ResourceServerTokenServices myUserInfoTokenServices() {
		return new CustomUserInfoTokenService(sso.getUserInfoUri(), sso.getClientId());
	}

	public static void main(String[] args) {
		SpringApplication.run(InventoryManagementServiceApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		// Create the Default Package Types to mock the H2 DB
		packageTypeService.createPackageType("Carton Box", "Small Box");
		packageTypeService.createPackageType("Carton Box", "Small Box2");
		packageTypeService.createPackageType("Carton Box", "Small Box3");
		packageTypeService.createPackageType("Carton Box", "Small Box4");
		packageTypeService.createPackageType("Carton Box", "Small Box5");
		packageTypeService.createPackageType("Carton Box", "Small Box5");
		packageTypeService.createPackageType("Carton Box", "Small Box5");
	}
	

}
