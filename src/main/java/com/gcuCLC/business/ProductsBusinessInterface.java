package com.gcuCLC.business;

import java.util.List;

import com.gcuCLC.entity.OrderEntity;
import com.gcuCLC.model.ProductModel;

public interface ProductsBusinessInterface {
	
	public void test();

	// Method to initiate bean instance
	public void init();
	
	// Method to destroy bean instance
	public void destroy();
	
	// Method to get List of Products
	public List<ProductModel> getProducts();
	
	// Method to add Products
	public List<ProductModel> AddItem(ProductModel item);

	// Method to add items
	void AddItems(List<String[]> items);

	// Method used for finding items in a List
	boolean ContainsItem(ProductModel item);
	
	// Method for Removing Items
	boolean RemoveItem(ProductModel item);

	OrderEntity findByPk(Integer pk);



}
