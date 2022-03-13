package com.gcuCLC.controller;

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
import com.gcuCLC.data.OrderDataService;
import com.gcuCLC.entity.OrderEntity;
import com.gcuCLC.entity.Orders;
import com.gcuCLC.model.Login;
import com.gcuCLC.model.ProductModel;
import com.gcuCLC.model.User;
//import com.gcuCLC.repository.OrdersRepository;
import com.gcuCLC.repository.OrdersRepository;

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
 * 1. Controller - Login Controller
 * ---------------------------------------------------------------------------
 * Modification History:
 * Date     Name                Comment
 * -------- ------------------- ----------------------------------------------
 * 01/18/2022 Team                Initial Creation
 *
 *
 */

// Login Controller controls Login Page Actions
@SuppressWarnings("unused")
@Controller
public class LoginController {
	
	@Autowired
	private ProductsBusinessInterface service;
	
	@Autowired
	private OrderDataService orderService;
	
	@Autowired
	private OrdersRepository orderRepo;

	/**
	 * Shows Login Page
	 * @param model - Auto Injection of Model
	 * @param user - Auto Injected User Class
	 * @param login - Auto Injected Login Class
	 * @return login - Login Page
	 */
	@GetMapping("/login")
	public String display(Model model, User user, Login login) {
		model.addAttribute("title", "Login Form");
		model.addAttribute("login", new Login());
		return "login";
	}

	public static Login login = new Login();//temp solution to passing the current login to other controllers
	
	/**
	 * Handles Login Response
	 * @param login - Auto Injected Login Class
	 * @param bindingResult - Auto Injected Binding Result Class
	 * @param model - Auto Injected Model
	 * @return viewOrders - Order Management Dashboard
	 */
	@SuppressWarnings("static-access")
	@PostMapping("/login")
	public String loginUser(/*@Valid*/@ModelAttribute Login login, BindingResult bindingResult, Model model) {		

		this.login = login;
		
		// Display something
		model.addAttribute("title", "Login Form");
		model.addAttribute("products", service.getProducts());
		model.addAttribute("orderEntity", new OrderEntity());
			
		return "viewOrders";
	}
		
}