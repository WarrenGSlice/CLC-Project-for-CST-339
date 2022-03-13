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
 * 1. Controller - Product Controller
 * ---------------------------------------------------------------------------
 * Modification History:
 * Date     Name                Comment
 * -------- ------------------- ----------------------------------------------
 * 01/18/2022 Team                Initial Creation
 *
 *
 */

@Controller
@RequestMapping("/productClone")
public class ProductController {
	
	@Autowired
	private ProductsBusinessInterface service;
	
	@Autowired
	private OrdersRepository orderRepo;

	public static OrderEntity orderEnt;
	
	/**
	 * Displays the Orders Page
	 * @param model - Auto Injected Model
	 * @param user - Auto Injected User
	 * @return productClone - Application Dashboard
	 */
	@GetMapping("/")
    public String displayProducts(Model model, User user) {
		
        model.addAttribute("title", "Product Form");
        model.addAttribute("user", new Login().getUsername());
        model.addAttribute("product", new ProductModel());
        return "productClone";
    }
	
	
	
	/**
	 * Handles the Response of viewing Orders
	 * @param productClone - Injection of Product Model
	 * @param bindingResult - Injection of Binding Result
	 * @param model - Injection of Model
	 * @return products - View Products Page
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
	 * Displays the Dashboard
	 * @param login - Injection of Login
	 * @param model - Injection of Model
	 * @param bindingResult - Injection of BindingResult
	 * @return - viewOrders - View Orders Page
	 */
	// View Orders Response
	@GetMapping("/viewOrders")
	public String viewOrder(@ModelAttribute Login login, Model model, BindingResult bindingResult)
	{		
		model.addAttribute("title" , "View All Orders");
		model.addAttribute("orderEntity", new OrderEntity());
		model.addAttribute("products" , service.getProducts());
		model.addAttribute("login", new Login());
		
		return "viewOrders";
	}
	
	public static Login login = new Login();
	
	/**
	 * Displays the Display page
	 * @param login - Injection of Login Model
	 * @param model - Injection of Model
	 * @return viewOrders - View Orders Page
	 */
	@SuppressWarnings("static-access")
	@GetMapping("/display")
	public String loginUser(@ModelAttribute Login login, Model model) {		
		
		this.login  = login;
		
		// Display something
		model.addAttribute("title", "Login Form");
		model.addAttribute("products", service.getProducts());
		model.addAttribute("orderEntity", new OrderEntity());
		
		
		return "viewOrders";
	}

	
	/**
	 * Shows the Edit Order Page Based on Order Id Selected
	 * @param orderId - Injection of Integer
	 * @param id - Injection of Integer
	 * @param form - Injection of Order Entity Entity
	 * @param session - Injection of HttpSession Attribute
	 * @param model - Injection of Model
	 * @param login - Injection of Login Model
	 * @return editOrder - Edit Order Page based on Order Id
	 */
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
	
	/**
	 * Creates Mapping for Order Deletion
	 * @param orderId - Injection of Integer
	 * @param id - Injection of Integer
	 * @param form - Injection of Order Entity Entity
	 * @param session - Injection of HttpSession Attribute
	 * @param model - Injection of Model
	 * @param login - Injection of Login Model
	 * @return removeOrder - Shows Remove Order Page for Order with the Id of orderId
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
		
	/**
	 * Update Order Page Based on OrderId
	 * @param login - Auto Injection of Login Model
	 * @param orderEntity - Auto Injection of Order Entity Entity
	 * @param model - Auto Injection of Model
	 * @param bindingResult - Auto Injection of Binding Result
	 * @param orders - Auto Injection of Orders Entity
	 * @return viewOrder - Takes User back to the Dashboard
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
	
	/**
	 * Handles Update Order Response Based on Order Id
	 * @param login - Auto Injection of Login Model
	 * @param orderEntity - Auto Injection of Order Entity Entity
	 * @param model - Auto Injection of Model
	 * @param bindingResult - Auto Injection of Binding Result
	 * @param orders - Auto Injection of Orders Entity
	 * @return viewOrders - Dashboard after Update Occurs
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
	
		/**
		* Handles Add Order Response
		* @param login - Auto Injection of Login Model
		* @param orderEntity - Auto Injection of Order Entity Entity
		* @param model - Auto Injection of Model
		* @param bindingResult - Auto Injection of Binding Result
		* @param orders - Auto Injection of Orders Entity
		* @return viewOrder - Dashboard after Adding Desired Order
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
		 * Used to Search for a Specific Product (Search Bar)
		 * @param login - Auto Injection of Login Model
		 * @param model - Auto Injection of Model
		 * @param searchTerm - Auto Injection of String type
		 * @return viewOrders - Dashboard with orders being searched for
		 */
		@RequestMapping(path = { "/search" })
		public String search(@ModelAttribute Login login, Model model, String searchTerm) {
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