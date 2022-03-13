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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.gcuCLC.repository.UserRepository;
import com.gcuCLC.entity.UserEntity;
import com.gcuCLC.model.Login;
//import com.gcuCLC.business.ProductsBusinessInterface;
import com.gcuCLC.model.User;

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
 * 1. Controller - Registration Controller
 * ---------------------------------------------------------------------------
 * Modification History:
 * Date     Name                Comment
 * -------- ------------------- ----------------------------------------------
 * 01/18/2022 Team                Initial Creation
 *
 *
 */

// Register Controller controls Register Page Actions
@Controller
@RequestMapping("/register")
public class RegisterController {

	@Autowired
	private UserRepository userRepo;
	
	/**
	 * Displays Registration Page
	 * @param model - Auto Injected Model
	 * @return register - Registration Page
	 */
	@GetMapping("/")
	public String showRegistrationForm(Model model) {
		model.addAttribute("title", "Register Form");
		model.addAttribute("user", new User());
		return "register";
	}

	/**
	 * Handles Post Registration
	 * @param user - Auto Injected User Model
	 * @param bindingResult - Auto Injected Binding Result
	 * @param model - Auto Injected Model
	 * @param ra - Auto Injected Redirect Attributes
	 * @param login - Auto Injected Login Model
	 * @param userEntity - Auto Injected User Entity Entity
	 * @return register - Register Page if error
	 * @return login - Login Page if Success
	 */
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
	
	}
	
}