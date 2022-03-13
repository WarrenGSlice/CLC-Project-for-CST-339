package com.gcuCLC.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gcuCLC.entity.OrderEntity;
import com.gcuCLC.model.ProductList;
import com.gcuCLC.model.ProductModel;
import com.gcuCLC.repository.OrdersRepository;
import com.gcuCLC.repository.StringRepo;

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
 * 1. Service - Products Rest Service
 * Has the code for the Order API's
 * ---------------------------------------------------------------------------
 * Modification History:
 * Date     Name                Comment
 * -------- ------------------- ----------------------------------------------
 * 01/18/2022 Team                Initial Creation
 *
 *
 */

@RestController
@RequestMapping("/service")
public class ProductsRestService {
	
	@Autowired
	private ProductsBusinessInterface service;
	
	@Autowired
	private OrdersRepository orderRepo;
	
	@Autowired
	private StringRepo stringRepo;
	
	/**
	 * API - Method gets all Products and Displays Them in JSON Format
	 * @return - All Products in JSON
	 */
	@GetMapping(path="/getJson", produces= {MediaType.APPLICATION_JSON_VALUE})
	public List<ProductModel> getProductsAsJson()
	{
		return service.getProducts();
	}
	
	/**
	 * Method gets all Products in XML Format
	 * @return Displays All Products in XML
	 */
	@GetMapping(path="/getXml", produces= {MediaType.APPLICATION_XML_VALUE})
	public ProductList getProductsXml() {
		ProductList productList = new ProductList();
		productList.setProducts(service.getProducts());
		return productList;
	}
	
	/**
	 * API - Lets User pull up Orders based on Order ID
	 * @param order_id - Corresponds to Order Order ID in Database
	 * @return Order that matches the searched for Order ID
	 */
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
	 * @param company_name - Corresponds to Company Name in Database
	 * @return orders by searched company name
	 */
	@GetMapping(path="/searchCompany/{company_name}", produces= {MediaType.APPLICATION_JSON_VALUE})
	public List<OrderEntity> getOrdersByCompanyName(@PathVariable("company_name") String company_name)
	{
		return stringRepo.findByCompanyName(company_name);
	}
	
	/**
	 * Searching By Customer Name
	 * @param customer_name - Corresponds to Customer Name in Database
	 * @return orders by searched customer name
	 */
	@GetMapping(path="/searchCustomer/{customer_name}", produces= {MediaType.APPLICATION_JSON_VALUE})
	public List<OrderEntity> getOrdersByCustomerName(@PathVariable("customer_name") String customer_name)
	{
		return stringRepo.findByCustomerName(customer_name);
	}
	
	/**
	 * Searching By Delivery Status
	 * @param delivery_status - Corresponds to Delivery Status in Database
	 * @return orders by searched delivery status
	 */
	@GetMapping(path="/searchStatus/{delivery_status}", produces= {MediaType.APPLICATION_JSON_VALUE})
	public List<OrderEntity> getOrdersByDeliveryStatus(@PathVariable("delivery_status") String delivery_status)
	{
		return stringRepo.findByDeliveryStatus(delivery_status);
	}
	
	/**
	 * Searching By Payment
	 * @param payment - Corresponds to Payment Type in Database
	 * @return orders by searched delivery status
	 */
	@GetMapping(path="/searchPayment/{payment}", produces= {MediaType.APPLICATION_JSON_VALUE})
	public List<OrderEntity> getOrdersByPayment(@PathVariable("payment") String payment)
	{
		return stringRepo.findByPayment(payment);
	}

}
