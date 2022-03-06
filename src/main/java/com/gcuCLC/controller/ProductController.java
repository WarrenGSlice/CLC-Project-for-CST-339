package com.gcuCLC.controller;


import java.util.ArrayList;

import javax.servlet.http.HttpSession;

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
import com.gcuCLC.entity.OrderEntity;
import com.gcuCLC.entity.Orders;
import com.gcuCLC.model.Login;
import com.gcuCLC.model.ProductModel;
import com.gcuCLC.model.User;
import com.gcuCLC.repository.OrdersRepository;



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
	
	/**
	 * 
	 * @param model
	 * @param user
	 * @return
	 */
	@GetMapping("/")
    public String displayProducts(Model model, User user) {
		
        model.addAttribute("title", "Product Form");
        model.addAttribute("user", new Login().getUsername());
        model.addAttribute("product", new ProductModel());
        return "productClone";
    }
	
	
	
	/**
	 * 
	 * @param productClone
	 * @param bindingResult
	 * @param model
	 * @return
	 */
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
	
	/**
	 * 
	 * @param login
	 * @param model
	 * @param bindingResult
	 * @return
	 */
	// View Orders Response
	@GetMapping("/viewOrders")
	public String viewOrder(@ModelAttribute Login login, Model model, BindingResult bindingResult)
	{
		//System.out.println("/viewOrder Order ID: " + orderEntity.getOrderId() + " " + orderEntity.toString());
		
		model.addAttribute("title" , "View All Orders");
		model.addAttribute("orderEntity", new OrderEntity());
		model.addAttribute("products" , service.getProducts());
		model.addAttribute("login", new Login());
		//model.addAttribute("viewOrders", orderEntity);
		
		return "viewOrders";
	}
	
	public static Login login = new Login();
	
	/**
	 * 
	 * @param login
	 * @param model
	 * @return
	 */
	@SuppressWarnings("static-access")
	@GetMapping("/display")
	public String loginUser(/*@Valid*/@ModelAttribute Login login, Model model) {		
		
		//service.getProducts();
		this.login  = login;
		
		// Display something
		model.addAttribute("title", "Login Form");
		model.addAttribute("products", service.getProducts());
		model.addAttribute("orderEntity", new OrderEntity());
		
		
		return "viewOrders";
	}

	
	@GetMapping("/editOrder/{orderId}")
	/**
	 * 
	 * @param orderId
	 * @param id
	 * @param form
	 * @param session
	 * @param model
	 * @param login
	 * @return
	 */
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
	/**
	 * 
	 * @param orderId
	 * @param id
	 * @param form
	 * @param session
	 * @param model
	 * @param login
	 * @return
	 */
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
		/**
		 * 
		 * @param login
		 * @param orderEntity
		 * @param model
		 * @param bindingResult
		 * @param orders
		 * @return
		 */
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
	/**
	 * 
	 * @param login
	 * @param orderEntity
	 * @param model
	 * @param bindingResult
	 * @param orders
	 * @return
	 */
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
		/**
		 * 
		 * @param login
		 * @param orderEntity
		 * @param model
		 * @param bindingResult
		 * @param orders
		 * @return
		 */
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
		
		
		/**
		 * Used to Search for a Specific Product
		 * @param login
		 * @param model
		 * @param searchTerm
		 * @return
		 */
		@RequestMapping(path = { "/search" })
		public String search(/* @Valid */@ModelAttribute Login login, Model model, String searchTerm) {
			System.out.println(searchTerm);
			ArrayList<ProductModel> tempList = new ArrayList<ProductModel>();
			if (searchTerm.isEmpty())
				model.addAttribute("products", service.getProducts());
			else {
				try {
					String[] entry = searchTerm.split(":");
					switch (entry[0]) {
						case "id":
							service.getProducts().forEach((p) -> {
								if (p.getOrderId() == Integer.parseInt(entry[1]))
									tempList.add(p);
							});
							model.addAttribute("products", tempList);
							break;
						case "company":
							service.getProducts().forEach((p) -> {
								if (p.getCompanyName().equalsIgnoreCase(entry[1]))
									tempList.add(p);
							});
							model.addAttribute("products", tempList);
							break;
						case "customer":
							service.getProducts().forEach((p) -> {
								if (p.getCustomerName().equalsIgnoreCase(entry[1]))
									tempList.add(p);
							});
							model.addAttribute("products", tempList);
							break;
						case "date":
							service.getProducts().forEach((p) -> {
								if (p.getDeliveryDate().equalsIgnoreCase(entry[1]))
									tempList.add(p);
							});
							model.addAttribute("products", tempList);
							break;
						case "price":
							service.getProducts().forEach((p) -> {
								if (p.getDeliveryPrice() == Integer.parseInt(entry[1]))
									tempList.add(p);
							});
							model.addAttribute("products", tempList);
							break;
						case "status":
							service.getProducts().forEach((p) -> {
								if (p.getDeliveryStatus().equalsIgnoreCase(entry[1]))
									tempList.add(p);
							});
							model.addAttribute("products", tempList);
							break;
						case "payment":
							service.getProducts().forEach((p) -> {
								if (p.getPayment().equalsIgnoreCase(entry[1]))
									tempList.add(p);
							});
							model.addAttribute("products", tempList);
							break;
						default:
							model.addAttribute("products", new ArrayList<ProductModel>());
							break;
					}
				} catch (Exception e) {
					model.addAttribute("products", tempList);
					model.addAttribute("orderEntity", new OrderEntity());
					return "viewOrders";
				}
			}
			model.addAttribute("orderEntity", new OrderEntity());
			return "viewOrders";
		}
	
}