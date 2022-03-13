package com.gcuCLC.business;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gcuCLC.data.OrderDataService;
import com.gcuCLC.entity.OrderEntity;
//import com.gcuCLC.entity.ProductsEntity;
import com.gcuCLC.model.ProductModel;

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
 * 1. Service - Products Business Service
 * ---------------------------------------------------------------------------
 * Modification History:
 * Date     Name                Comment
 * -------- ------------------- ----------------------------------------------
 * 01/18/2022 Team                Initial Creation
 *
 *
 */

@Service
public class ProductsBusinessService implements ProductsBusinessInterface{
	
	@Autowired
	private OrderDataService service;
	List<ProductModel> products = new ArrayList<>();
	
	/**
	 * Method to Add Order to Products Page
	 * @param item - Full Order of ProductModel Type
	 * @return products - List of Orders
	 */
	@Override
	public List<ProductModel> AddItem(ProductModel item) {
		products.add(item);
		return products;
	}
	
	/**
	 * Method to send message to console when this service is used
	 */
	@Override
	public void test() {
		System.out.println("Hello from the ProductsBusinessService");
	}

	/**
	 * Method to Return the List of Orders
	 * @return - List of Orders
	 */
	@Override
	public List<ProductModel> getProducts() {
		
		// Get all the Entity Orders
		List<OrderEntity> orderEntity = service.findAll();
		
		// Iterate over the Entity Orders and create a list of Domain orders
		List<ProductModel> ordersDomain = new ArrayList<ProductModel>();
		for(OrderEntity entity : orderEntity)
		{
			ordersDomain.add(new ProductModel(entity.getOrderId(), entity.getCompanyName(), entity.getCustomerName(),
							 entity.getDeliveryDate(), entity.getDeliveryPrice(),
							 entity.getDeliveryStatus(), entity.getPayment()));
		}
		// Return a List of Domain Orders
		return ordersDomain;
	}
	
	/**
	 * Method to Find Order by Order Id
	 * @param pk - Order Id
	 * @return dto - Order of the OrderEntity type
	 * Non Used In Program
	 */
	@Override
	@Transactional
	public OrderEntity findByPk(Integer pk) {
		System.out.println("OrderDataService findBypk method start");
		OrderEntity dto = service.findByPk(pk);
		System.out.println("OrderDataService findByPk method end");
		return dto;
	}
	
	/**
	 * Method to console message when class is initialized
	 */
	@Override
	public void init() {
		System.out.println("BusinessService Initialized");
	}

	/**
	 * Tells Console when Service is destroyed
	 */
	@Override
	public void destroy() {
		System.out.println("BusinessService Destroyed");	
	}
	
	/**
	 * Method to Add items to List Array by creating a new
	 * Product Model Object whenever a new item is added
	 * @param items - Auto Injected List of String Array items
	 */
	@Override
	public void AddItems(List<String[]> items) {
		for (String[] item : items) {
			ProductModel newItem = new ProductModel(item);
			AddItem(newItem);
		}		
	}
	
	/**
	 * Method to Search for Orders Containing 
	 * certain properties
	 * @param item - Order of ProductModel Type
	 * @return products - List of Products containing item
	 * Non-Used in Program
	 */
	@Override
	public boolean ContainsItem(ProductModel item) {
		return products.contains(item);
	}
	
	/**
	 * Method to Remove Items
	 * @return true - removes if found
	 * @return false - does nothing
	 */
	@Override
	public boolean RemoveItem(ProductModel item) {
		if(ContainsItem(item)) {
			products.remove(item);
			return true;
		}
		return false;
	}
	

	
}
