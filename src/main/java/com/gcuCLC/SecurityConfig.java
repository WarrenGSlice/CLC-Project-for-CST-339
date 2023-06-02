package com.gcuCLC;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.gcuCLC.business.UserBusinessService;

/**
 * ---------------------------------------------------------------------------
 * Name      : Group H1
 * Members   : W. Peterson, J. LeVan, and I. Gudino  
 * Date      : 2022-03-11
 * Class     : CST-339 Java Programming III
 * Professor : Brandon Bass
 * Assignment: Milestone - CLC Group Assignment
 * Disclaimer: This is our own work
 * ---------------------------------------------------------------------------
 * Description:
 * 1. Main Application - Security Configuration
 * ---------------------------------------------------------------------------
 * Modification History:
 * Date     Name                Comment
 * -------- ------------------- ----------------------------------------------
 * 02/18/2022 Team                Initial Creation
 *
 *
 */

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Autowired
	UserBusinessService service;
	
	/**
	 * Enables Password Encryption
	 * @return BCryptPasswordEncoder
	 */
	@Bean
	BCryptPasswordEncoder passwordEncoder()
	{
		return new BCryptPasswordEncoder();
	}
	
	/**
	 * Allows Program pass details other than userName And password
	 * to the rest of the program. Works with the gcuCLCuserDetails
	 * class
	 * @return authProvider - Uses DaoAuthenticationProvider
	 */
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
		authProvider.setUserDetailsService(userDetailsService());
		authProvider.setPasswordEncoder(passwordEncoder());
		return authProvider;
	}
	
	/**
	 * Security Configuration - Defining security layout
	 * @param http - Auto Injected HttpSecurity
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception
	{
		http.csrf().disable()
		.httpBasic()
			.and()
			.authorizeRequests()
			.antMatchers("/service/**").authenticated()
			.and()
			.authorizeRequests()
				.antMatchers("**","/", "/images/**", "/register/**", "/navbar/**", "/home-navbar/**", "/footer/**", "/index/**", "/head-section/**", "/css/**", "/fonts/**" ).permitAll()
				.anyRequest().authenticated()
				.and()
			.formLogin()
				.loginPage("/login")
				.usernameParameter("username")
				.passwordParameter("password")
				.permitAll()
				.defaultSuccessUrl("/productClone/display", true) //--->may need to mess with this could just be /viewOrders
				.and()
			.logout()
				.logoutUrl("/logout") // --> May need to change this to home /
				.invalidateHttpSession(true)
				.clearAuthentication(true)
				.permitAll()
				.logoutSuccessUrl("/");
				
	}
	
	/**
	 * Security Configuration - Define encoding
	 * @param auth - Auto Injected AuthenticationManagerBuilder
	 */
	@Autowired
	public void configure(AuthenticationManagerBuilder auth) throws Exception
	{
		auth
		.userDetailsService(service)
		.passwordEncoder(passwordEncoder);
	}
	
}
