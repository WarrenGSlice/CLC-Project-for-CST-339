package com.gcuCLC;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.gcuCLC.business.UserBusinessService;
import com.gcuCLC.model.gcuCLCuserDetails;
/**
 * This is Warren's Side branch
 * @author warre
 *
 */

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Autowired
	UserBusinessService service;
	
	@Bean
	BCryptPasswordEncoder passwordEncoder()
	{
		return new BCryptPasswordEncoder();
	}
	
//	@Bean
//	public UserDetailsService userDetailsService() {
//		return new gcuCLCuserDetails();
//	}
	
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
		authProvider.setUserDetailsService(userDetailsService());
		authProvider.setPasswordEncoder(passwordEncoder());
		return authProvider;
	}
	
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
				.antMatchers("/", "/images/**", "/register/**", "/navbar/**", "/home-navbar/**", "/footer/**", "/index/**", "/head-section/**", "/css/**", "/fonts/**" ).permitAll()
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
	
	@Autowired
	public void configure(AuthenticationManagerBuilder auth) throws Exception
	{
		auth
		.userDetailsService(service)
		.passwordEncoder(passwordEncoder);
	}
	
	// For 6.1 In-Memory Authorization
//	@Autowired
//	public void configure(AuthenticationManagerBuilder auth) throws Exception
//	{
//		auth.inMemoryAuthentication()
//			.withUser("WarrenGSlice").password("{noop}Dreamteam").roles("USER"); // <--- Is the role correct?
//	}
}
