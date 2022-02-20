package com.gcuCLC.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

/** * * * * * * * * * * * * * * *
 * CST-339 CLC Milestone Project
 * Order Management Application *
 * Created by Warren Peterson,* *
 * Jonathan Levan, Ivan Gudino  *
 * * * * * * * * * * * * * * * **/ 

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.DataSourceBuilder;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.gcuCLC.repository.UserRepository;
import com.gcuCLC.data.UserDataService;
import com.gcuCLC.entity.UserEntity;
import com.gcuCLC.model.Login;
//import com.gcuCLC.business.ProductsBusinessInterface;
import com.gcuCLC.model.User;

// Register Controller controls Register Page Actions
@Controller
@RequestMapping("/register")
public class RegisterController {

	@Autowired
	private UserRepository userRepo;
	
    // Show Register form
	@GetMapping("/")
	public String showRegistrationForm(Model model) {
		model.addAttribute("title", "Register Form");
		model.addAttribute("user", new User());
		return "register";
	}

	// Register new user
	@PostMapping("/doRegister")
	public String saveUser(@ModelAttribute@Valid User user, BindingResult bindingResult, Model model, RedirectAttributes ra, Login login, UserEntity userEntity) {		
		
		System.out.println("/doRegister Username: " + userEntity.getUsername() + " " + userEntity.toString() );
		
		// Check for validation errors
		if (bindingResult.hasErrors()) {
			model.addAttribute("title", "Register Form");
			return "register";
		}
		
		model.addAttribute("title", "Register Form");
		
		userEntity.setUsername(userEntity.getUsername());
		userEntity.setFirstName(userEntity.getFirstName());
		userEntity.setLastName(userEntity.getLastName());
		userEntity.setAddress(userEntity.getAddress());
		userEntity.setCity(userEntity.getCity());
		userEntity.setState(userEntity.getState());
		userEntity.setZip(userEntity.getZip());
		userEntity.setEmail(userEntity.getEmail());
		userEntity.setPassword(userEntity.getPassword());
		userEntity.setBusinessName(userEntity.getBusinessName());
		userEntity.setPhone(userEntity.getPhone());
		
		//userRepo.save(userEntity);
		
		//UserEntity ue = new UserEntity(user);
		//ue = orderRepo
		//UserDataService uds = new UserDataService(null, getDataSource());
        if(userRepo.findByUsername(userEntity.getUsername()) != null)
        {
			ra.addFlashAttribute("error", "User with that username already exists");
			return "redirect:/register/";
		}
        else
        {
			userRepo.save(userEntity);
			ra.addFlashAttribute("success", "User Created!");
			return "redirect:/login/";
		}
	
		
		//return "registerSuccess";
	}
	
//	public DataSource getDataSource() {
//		@SuppressWarnings("rawtypes")
//		DataSourceBuilder dsb = DataSourceBuilder.create();
//		dsb.url("jdbc:mysql://localhost:3306/oms");
//		dsb.username("root");
//		dsb.password("root");
//		dsb.driverClassName("com.mysql.cj.jdbc.Driver");
//		return dsb.build();
//	}
	
}