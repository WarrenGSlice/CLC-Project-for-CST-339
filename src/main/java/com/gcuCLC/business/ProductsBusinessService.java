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

@Service
public class ProductsBusinessService implements ProductsBusinessInterface{
	
//	@Autowired
//	private DataAccessInterface orderDAO;
	@Autowired
	private OrderDataService service;
	//public List<ProductModel> Inventory = new ArrayList<>();
	List<ProductModel> products = new ArrayList<>();
	
	@Override
	// Method to add Items to the Product page
	public List<ProductModel> AddItem(ProductModel item) {
		products.add(item);
		return products;
	}
	
	@Override
	public void test() {
		System.out.println("Hello from the ProductsBusinessService");
	}

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
	
	@Override
	@Transactional
	public OrderEntity findByPk(Integer pk) {
		System.out.println("OrderDataService findBypk method start");
		OrderEntity dto = service.findByPk(pk);
		System.out.println("OrderDataService findByPk method end");
		return dto;
		
	}
	
	@Override
	public void init() {
		System.out.println("BusinessService Initialized");
	}

	@Override
	public void destroy() {
		System.out.println("BusinessService Destroyed");	
	}
	
	// Method to add items to List Array by creating a new Product Model Object whenever a new item is added
	@Override
	public void AddItems(List<String[]> items) {
		for (String[] item : items) {
			ProductModel newItem = new ProductModel(item);
			AddItem(newItem);
		}		
	}
	
	// Method to find items in item list
	@Override
	public boolean ContainsItem(ProductModel item) {
		return products.contains(item);
	}
	
	// Method to Remove Items
	@Override
	public boolean RemoveItem(ProductModel item) {
		if(ContainsItem(item)) {
			products.remove(item);
			return true;
		}
		return false;
	}
	

	
}
