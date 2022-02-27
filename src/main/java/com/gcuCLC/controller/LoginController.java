package com.gcuCLC.controller;

import javax.sql.DataSource;

/** * * * * * * * * * * * * * * *
 * CST-339 CLC Milestone Project
 * Order Management Application *
 * Created by Warren Peterson,* *
 * Jonathan Levan, Ivan Gudino  *
 * * * * * * * * * * * * * * * **/ 

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.servlet.ModelAndView;

import com.gcuCLC.business.ProductsBusinessInterface;
import com.gcuCLC.data.DataAccessInterface;
import com.gcuCLC.data.OrderDataService;
import com.gcuCLC.data.UserDataService;
import com.gcuCLC.entity.OrderEntity;
import com.gcuCLC.entity.Orders;
import com.gcuCLC.entity.UserEntity;
import com.gcuCLC.model.Login;
import com.gcuCLC.model.ProductModel;
import com.gcuCLC.model.User;
//import com.gcuCLC.repository.OrdersRepository;
import com.gcuCLC.repository.OrdersRepository;
import com.gcuCLC.repository.UserRepository;

// Login Controller controls Login Page Actions
@SuppressWarnings("unused")
@Controller
public class LoginController {
	
	@Autowired
	private ProductsBusinessInterface service;
	
	@SuppressWarnings("unused")
	@Autowired
	private OrderDataService orderService;
	
	@Autowired
	private OrdersRepository orderRepo;

	
	// Show Login form
	@GetMapping("/login")
	public String display(Model model) {
		model.addAttribute("title", "Login Form");
		model.addAttribute("login", new Login());
		return "login";
	}
	
	
	public static Login login = new Login();//temp solution to passing the current login to other controllers
	
	// Login user

	
	@PostMapping("/loginSender")
	public String loginSender(@ModelAttribute Login login, Model model)
	{
		
		return "redirect:/productClone/display";
	}

//	@SuppressWarnings("static-access")
//	@PostMapping("/doLogin")
//	public String loginUser(/*@Valid*/@ModelAttribute Login login, BindingResult bindingResult, Model model) {		
//		
//		
//		service.test();
//		//security.authenticate("username", "password");
//		
//		// Check for validation errors
//		if (bindingResult.hasErrors()) {
//			model.addAttribute("title", "Login Form");
//			return "login";
//		}
//		
//		//service.getProducts();
//		this.login = login;
//		
//		// Display something
//		model.addAttribute("title", "Login Form");
//		model.addAttribute("products", service.getProducts());
//		model.addAttribute("orderEntity", new OrderEntity());
//		
//		
//		return "viewOrders";
//	}
	
//	@SuppressWarnings("static-access")
//	@RequestMapping("/signout")
//	public String signout() {		
//		this.login = null;
//		UserController.user = null;
//
//		return "index";
//	}
		
}