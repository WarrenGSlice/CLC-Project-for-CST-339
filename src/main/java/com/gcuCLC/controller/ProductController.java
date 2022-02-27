package com.gcuCLC.controller;


import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gcuCLC.business.ProductsBusinessInterface;
import com.gcuCLC.data.UserDataService;
import com.gcuCLC.entity.OrderEntity;
import com.gcuCLC.entity.Orders;
import com.gcuCLC.model.Login;
import com.gcuCLC.model.ProductModel;
import com.gcuCLC.model.User;
import com.gcuCLC.repository.OrdersRepository;
import com.gcuCLC.repository.UserRepository;



@Controller
@RequestMapping("/productClone")
public class ProductController {
	
	
//	@Autowired
//	private EditOrderRepository editRepo;
	
	@Autowired
	private ProductsBusinessInterface service;
	
//	@Autowired
//	private OrderDataService ods;
	
	@Autowired
	private OrdersRepository orderRepo;
	
	public static OrderEntity orderEnt;
	
	@GetMapping("/")
    public String displayProducts(Model model, User user) {
		
        model.addAttribute("title", "Product Form");
        model.addAttribute("user", new Login().getUsername());
        model.addAttribute("product", new ProductModel());
        return "productClone";
    }
	
	
	
	
	@PostMapping("/doProductClone")
	public String ProductPage(@ModelAttribute("products") ProductModel productClone, BindingResult bindingResult, Model model) {		
			
		// Check for validation errors
		if (bindingResult.hasErrors()) {
			model.addAttribute("title", "Login Form");
			return "login";
		}
		
		model.addAttribute("Product Form", productClone); 
		model.addAttribute("products", service.getProducts());
		return "products";
	}
	
	// View Orders Response
	@GetMapping("/viewOrders")
	public String viewOrder(@ModelAttribute Login login, Model model, BindingResult bindingResult)
	{
		//System.out.println("/viewOrder Order ID: " + orderEntity.getOrderId() + " " + orderEntity.toString());
		
		model.addAttribute("title" , "View All Orders");
		model.addAttribute("orderEntity", new OrderEntity());
		model.addAttribute("products" , service.getProducts());
		model.addAttribute("login", this.login);
		//model.addAttribute("viewOrders", orderEntity);
		
		return "viewOrders";
	}
	
	public static Login login = new Login();
	@Autowired
	private UserRepository userRepo;
	@Autowired
	private DataSource dataSource;

	@SuppressWarnings("static-access")
	@PostMapping("/display")
	public String loginUser(Login login, Model model) {		
		
		//service.getProducts();
		ProductController.login  = login;
		UserDataService uds = new UserDataService(userRepo, dataSource);
		UserController.user = new User(uds.findByUsername(login.getUsername()));
		// Display something
		model.addAttribute("title", "Login Form");
		model.addAttribute("products", service.getProducts());
		model.addAttribute("orderEntity", new OrderEntity());
		
		
		return "viewOrders";
	}

	
	@GetMapping("/editOrder/{orderId}")
	public String displayFoundId (@RequestParam(required = false) Integer orderId, Integer id, @ModelAttribute("form") OrderEntity form, HttpSession session, Model model, Login login ) {
		
		if (form.getOrderId() > 0) {
		}
		OrderEntity ue;
		ue = orderRepo.findByOrderId(form.getOrderId());
		ProductController.orderEnt = new OrderEntity(ue);

		System.out.println("/editOrder Order ID: " + form.getOrderId() + " " + "Company Name: " + form.getCompanyName() + " " +form.toString() );
		model.addAttribute("orderEntity", form);
		model.addAttribute("orderEntity", ProductController.orderEnt);
		model.addAttribute("login", new Login());
		
		return "editOrder";
	}
	
	//Mapping for Order Deletion
		@GetMapping("/removeOrder/{orderId}")
		public String deleteSingle(@RequestParam(required = false) Integer orderId, Integer id, @ModelAttribute("form") OrderEntity form, HttpSession session, Model model, Login login ) {
			
			if (form.getOrderId() > 0) {
			}
			OrderEntity ue;
			ue = orderRepo.findByOrderId(form.getOrderId());
			ProductController.orderEnt = new OrderEntity(ue);

			System.out.println("/removeOrder Order ID: " + form.getOrderId() + " " + "Company Name: " + form.getCompanyName() + " " +form.toString() );
			model.addAttribute("orderEntity", form);
			model.addAttribute("orderEntity", ProductController.orderEnt);
			model.addAttribute("login", new Login());
			
			return "removeOrder";
		}
		
	// Update Orders Response
	@PostMapping("/changeOrder")
	public String updateOrder(@ModelAttribute Login login, OrderEntity orderEntity, Model model, BindingResult bindingResult, Orders orders )
	{
			orderEntity.setOrderId(orderEntity.getOrderId());
			orderEntity.setCompanyName(orderEntity.getCompanyName());
			orderEntity.setCustomerName(orderEntity.getCustomerName());
			orderEntity.setDeliveryDate(orderEntity.getDeliveryDate());
			orderEntity.setDeliveryPrice(orderEntity.getDeliveryPrice());
			orderEntity.setDeliveryStatus(orderEntity.getDeliveryStatus());
			orderEntity.setPayment(orderEntity.getPayment());
		
		orderRepo.save(orderEntity);
		
		model.addAttribute("title", "Order Updated");
		model.addAttribute("orderEntity", new OrderEntity());
		model.addAttribute("products", service.getProducts());
		model.addAttribute("editOrder", orderEntity);
		model.addAttribute("products", orderEntity);
		model.addAttribute("login", new Login());
		
		return viewOrder(login, model, bindingResult); //changed from "viewOrders"
	}
	
	// Update Orders Response
		@PostMapping("/removeOrder")
		public String deleteOrder(@ModelAttribute Login login, OrderEntity orderEntity, Model model, BindingResult bindingResult, Orders orders )
		{
				orderEntity.setOrderId(orderEntity.getOrderId());
				orderEntity.setCompanyName(orderEntity.getCompanyName());
				orderEntity.setCustomerName(orderEntity.getCustomerName());
				orderEntity.setDeliveryDate(orderEntity.getDeliveryDate());
				orderEntity.setDeliveryPrice(orderEntity.getDeliveryPrice());
				orderEntity.setDeliveryStatus(orderEntity.getDeliveryStatus());
				orderEntity.setPayment(orderEntity.getPayment());
			
			orderRepo.delete(orderEntity);
			
			model.addAttribute("title", "Order Updated");
			model.addAttribute("orderEntity", new OrderEntity());
			model.addAttribute("products", service.getProducts());
			model.addAttribute("editOrder", orderEntity);
			model.addAttribute("products", orderEntity);
			model.addAttribute("login", new Login());
			
			return viewOrder(login, model, bindingResult); //changed from "viewOrders"
		}
	
		//Show product viewer
		@PostMapping("/addOrder")
		public String addOrder(@ModelAttribute Login login, OrderEntity orderEntity, Model model, BindingResult bindingResult, Orders orders)
		{
			System.out.println("/addOrder Order ID: " + orderEntity.getOrderId() + " " + orderEntity.toString() );
			
			orderEntity.setCustomerName(orderEntity.getCustomerName());
			orderEntity.setDeliveryDate(orderEntity.getDeliveryDate());
			orderEntity.setDeliveryPrice((int)orderEntity.getDeliveryPrice());
			orderEntity.setDeliveryStatus(orderEntity.getDeliveryStatus());
			orderEntity.setCompanyName(orderEntity.getCompanyName());
			orderEntity.setPayment(orderEntity.getPayment());
			
			orderRepo.save(orderEntity);
			
			model.addAttribute("title", "Order Created");
			model.addAttribute("orderEntity", new OrderEntity());
			model.addAttribute("products", service.getProducts());
			model.addAttribute("products", orderEntity);
			model.addAttribute("login", new Login());

			return viewOrder(login, model, bindingResult);
		}
	
}