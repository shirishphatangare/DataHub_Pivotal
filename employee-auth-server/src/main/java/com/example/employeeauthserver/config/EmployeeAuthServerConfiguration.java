package com.example.employeeauthserver.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;

@Configuration
@EnableAuthorizationServer
public class EmployeeAuthServerConfiguration extends AuthorizationServerConfigurerAdapter {

	private final String CLIENT_ID = "employeeapp";
	private final String CLIENT_SECRET = "pass";
	private final String GRANT_TYPE = "authorization_code";
	private final String SCOPE = "read";
	
	// Hardcoding client registration with Employee Auth server
	@Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		BCryptPasswordEncoder encoder = passwordEncoder();
        clients.inMemory().withClient(CLIENT_ID).secret(encoder.encode(CLIENT_SECRET)).authorizedGrantTypes(GRANT_TYPE)
            .scopes(SCOPE).authorities("CLIENT");
    }
	
	
	@Override 
	   public void configure(AuthorizationServerSecurityConfigurer oauthServer) throws Exception { 
	       oauthServer.checkTokenAccess("permitAll()"); 
	   }
	
	@Bean
	public static BCryptPasswordEncoder passwordEncoder() {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder;
	}
	
}