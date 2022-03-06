package com.gcuCLC.business;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gcuCLC.data.DataAccessInterface;
import com.gcuCLC.entity.OrderEntity;
import com.gcuCLC.model.Login;
import com.gcuCLC.model.ProductList;
import com.gcuCLC.model.ProductModel;
import com.gcuCLC.repository.OrdersRepository;
import com.gcuCLC.repository.StringRepo;

@RestController
@RequestMapping("/service")
public class ProductsRestService {
	
	@Autowired
	private ProductsBusinessInterface service;
	
	@Autowired
	private OrdersRepository orderRepo;
	
	@Autowired
	private StringRepo stringRepo;
	
	

	@GetMapping(path="/getJson", produces= {MediaType.APPLICATION_JSON_VALUE})
	public List<ProductModel> getProductsAsJson()
	{
		return service.getProducts();
	}
	
	@GetMapping(path="/getXml", produces= {MediaType.APPLICATION_XML_VALUE})
	public ProductList getProductsXml() {
		ProductList productList = new ProductList();
		productList.setProducts(service.getProducts());
		return productList;
	}
	
	@GetMapping(path="/searchId/{order_id}", produces= {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<?> getOrdersById(@PathVariable("order_id") String order_id)
	{
		try
		{
			int id = Integer.parseInt(order_id);
			OrderEntity result = (OrderEntity) orderRepo.findByOrderId(id);
			
			if (result == null)
				return new ResponseEntity<>(new OrderEntity(-1), HttpStatus.NOT_FOUND);
			else
				return new ResponseEntity<>(result, HttpStatus.OK);
		} 
		catch (NumberFormatException e)
		{
			return new ResponseEntity<>(new OrderEntity(-1), HttpStatus.BAD_REQUEST);
		}
		catch (Exception e)
		{
			return new ResponseEntity<>(new OrderEntity(-1), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	/**
	 * Searching By Company Name
	 * @param company_name
	 * @return orders by searched company name
	 */
	@GetMapping(path="/searchCompany/{company_name}", produces= {MediaType.APPLICATION_JSON_VALUE})
	public List<OrderEntity> getOrdersByCompanyName(@PathVariable("company_name") String company_name)
	{
		return stringRepo.findByCompanyName(company_name);
	}
	
	/**
	 * Searching By Customer Name
	 * @param customer_name
	 * @return orders by searched customer name
	 */
	@GetMapping(path="/searchCustomer/{customer_name}", produces= {MediaType.APPLICATION_JSON_VALUE})
	public List<OrderEntity> getOrdersByCustomerName(@PathVariable("customer_name") String customer_name)
	{
		return stringRepo.findByCustomerName(customer_name);
	}
	
	/**
	 * Searching By Delivery Status
	 * @param delivery_status
	 * @return orders by searched delivery status
	 */
	@GetMapping(path="/searchStatus/{delivery_status}", produces= {MediaType.APPLICATION_JSON_VALUE})
	public List<OrderEntity> getOrdersByDeliveryStatus(@PathVariable("delivery_status") String delivery_status)
	{
		return stringRepo.findByDeliveryStatus(delivery_status);
	}
	
	/**
	 * Searching By Payment
	 * @param payment
	 * @return orders by searched delivery status
	 */
	@GetMapping(path="/searchPayment/{payment}", produces= {MediaType.APPLICATION_JSON_VALUE})
	public List<OrderEntity> getOrdersByPayment(@PathVariable("payment") String payment)
	{
		return stringRepo.findByPayment(payment);
	}

}
