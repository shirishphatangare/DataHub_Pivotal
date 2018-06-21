package com.example.employeeauthserver.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@Configuration
@EnableWebSecurity
public class EmployeeResourceServerConfiguration extends WebSecurityConfigurerAdapter {
	
	private final String USERNAME1 = "user1";
	private final String PASSWORD1 = "password1";
	private final String USERNAME2 = "user2";
	private final String PASSWORD2 = "password2";
	
	
	/*@Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/resources/**");
    }*/

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/").permitAll()
        .and().formLogin().permitAll()
        .and().logout().permitAll();
        
        http.csrf().disable();
    }

    @Override
    public void configure(AuthenticationManagerBuilder authenticationMgr) throws Exception {
    	BCryptPasswordEncoder encoder = passwordEncoder();
    	
    	authenticationMgr.inMemoryAuthentication().
    	withUser("admin").password(encoder.encode("admin")).roles("ADMIN").authorities("ROLE_ADMIN").and().
    	withUser(USERNAME1).password(encoder.encode(PASSWORD1)).roles("USER").authorities("ROLE_USER").and().
		withUser(USERNAME2).password(encoder.encode(PASSWORD2)).roles("USER").authorities("ROLE_USER");
    }
    
    
    @Bean
	public static BCryptPasswordEncoder passwordEncoder() {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder;
	}
}	
