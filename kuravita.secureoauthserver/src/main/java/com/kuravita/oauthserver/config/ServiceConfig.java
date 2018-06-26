package com.kuravita.oauthserver.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.GlobalAuthenticationConfigurerAdapter;

@Configuration
public class ServiceConfig extends GlobalAuthenticationConfigurerAdapter {
	
	 
	
	@Override
	public void init(AuthenticationManagerBuilder auth) throws Exception{
		auth.inMemoryAuthentication()
		   .withUser("gustave").password("gus").roles("USER").and()
		   .withUser("moise").password("moise").roles("USER");
		
	}
}
