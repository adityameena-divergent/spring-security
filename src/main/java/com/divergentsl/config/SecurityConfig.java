package com.divergentsl.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import com.divergentsl.service.LoginUserDetailService;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	/**
	 * Using InMemoryUserDetailsManager
	 * @return
	 */
	/*
	@Bean
	public UserDetailsService userDetailsService() {
		var userDetails = new InMemoryUserDetailsManager();
		var user = User.withUsername("admin")
		.password("root")
		.authorities("read")
		.build();
		userDetails.createUser(user);
		return userDetails;
	}
	*/
	
	/**
	 * Using Jpa
	 * @return
	 */
	@Bean
	public UserDetailsService userDetailsService() {
		return new LoginUserDetailService();
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}
	
}
