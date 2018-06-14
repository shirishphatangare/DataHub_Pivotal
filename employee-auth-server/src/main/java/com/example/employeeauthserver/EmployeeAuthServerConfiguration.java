package com.example.employeeauthserver;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class EmployeeAuthServerConfiguration extends GlobalAuthenticationConfigurerAdapter{

	private final String USERNAME1 = "user1";
	private final String PASSWORD1 = "password1";
	private final String USERNAME2 = "user2";
	private final String PASSWORD2 = "password2";
	
	

	// Initialize user credentials - hardcoded for simplicity - JPA and DB can be used for production
	@Override
	public void init(AuthenticationManagerBuilder auth) throws Exception {
		 BCryptPasswordEncoder encoder = passwordEncoder();
		
		auth.inMemoryAuthentication().passwordEncoder(passwordEncoder()).withUser(USERNAME1).password(encoder.encode(PASSWORD1)).roles("USER").and().
		withUser(USERNAME2).password(encoder.encode(PASSWORD2)).roles("ADMIN");
	}
	
	@Bean
	public static BCryptPasswordEncoder passwordEncoder() {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder;
	}

}
