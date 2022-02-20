package com.gcuCLC.business;

import java.util.ArrayList;
import java.util.List;

import com.gcuCLC.entity.OrderEntity;
import com.gcuCLC.model.ProductList;
import com.gcuCLC.model.ProductModel;

public class AnotherProductsBusinessService implements ProductsBusinessInterface{

	// List to hold products to be viewed on Products page
	List<ProductModel> products = new ArrayList<ProductModel>();
	List<OrderEntity> orders = new ArrayList<OrderEntity>();
	
	@Override
	// Method to add Items to the Product page
	public List<ProductModel> AddItem(ProductModel item) {
		products.add(item);
		return null;
	}
	
	@Override
	public void test() {
		System.out.println("Hello from the AnotherProductsBusinessService");
	}

	@Override
	public List<ProductModel> getProducts() {

		return products;
	}
	
	// Method to add items to List Array by creating a new Product Model Object whenever a new item is added
	@Override
	public void AddItems(List<String[]> items) {
		for (String[] item : items) {
			ProductModel newItem = new ProductModel(item);
			AddItem(newItem);
		}		
	}
	
	@Override
	public void init() {
		System.out.println("BusinessService Initialized");
	}

	@Override
	public void destroy() {
		System.out.println("BusinessService Destroyed");	
	}
	
	// Method to find items in item list
	
	public boolean ContainsItem(ProductModel item) {
		return false /*products.contains(item)*/;
	}
	
	// Method to Remove Items
	//@Override
	public boolean RemoveItem(ProductModel item) {
		if(ContainsItem(item)) {
			products.remove(item);
			return true;
		}
		return false;
	}

	@Override
	public OrderEntity findByPk(Integer pk) {
		// TODO Auto-generated method stub
		return null;
	}

		
}
