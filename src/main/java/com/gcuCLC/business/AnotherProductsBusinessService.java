package com.gcuCLC.business;

import java.util.ArrayList;
import java.util.List;

import com.gcuCLC.entity.OrderEntity;
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
 * 1. Service - Business
 * ---------------------------------------------------------------------------
 * Modification History:
 * Date     Name                Comment
 * -------- ------------------- ----------------------------------------------
 * 01/18/2022 Team                Initial Creation
 * This class doesn't really do anything, was a helper class for earlier in 
 * the programs life-cycle
 */

public class AnotherProductsBusinessService implements ProductsBusinessInterface{

	// List to hold products to be viewed on Products page
	List<ProductModel> products = new ArrayList<ProductModel>();
	List<OrderEntity> orders = new ArrayList<OrderEntity>();
	
	/**
	 * Service - adds an Item to Product List
	 * @param item - Auto Injected ProductModel
	 * @return null - method is non-functional
	 */
	@Override
	// Method to add Items to the Product page
	public List<ProductModel> AddItem(ProductModel item) {
		products.add(item);
		return null;
	}
	
	/**
	 * Service - Lets Console know when this class is used
	 */
	@Override
	public void test() {
		System.out.println("Hello from the AnotherProductsBusinessService");
	}

	/**
	 * Service - Gets List of products
	 * @return products - returns list of products
	 */
	@Override
	public List<ProductModel> getProducts() {

		return products;
	}
	
	/**
	 * Service - Adds Items to List array by creating a
	 * new ProductModel Object whenever a new item is added
	 * @param items - Auto Injected List of String Array Type Object
	 */
	@Override
	public void AddItems(List<String[]> items) {
		for (String[] item : items) {
			ProductModel newItem = new ProductModel(item);
			AddItem(newItem);
		}		
	}
	
	/**
	 * Service - Console message for initialization
	 */
	@Override
	public void init() {
		System.out.println("BusinessService Initialized");
	}

	/**
	 * Service - Console message for destruction
	 */
	@Override
	public void destroy() {
		System.out.println("BusinessService Destroyed");	
	}
	
	/**
	 * Service - finds items that contain
	 * @param item - Auto Injected ProductModel
	 * @return false - method is non-functional
	 */
	public boolean ContainsItem(ProductModel item) {
		return false /*products.contains(item)*/;
	}
	
	/**
	 * Service - removes Items
	 * @param item - Auto Injected ProductModel
	 * @return true - if contains item
	 * @return false - if not contains item
	 */
	public boolean RemoveItem(ProductModel item) {
		if(ContainsItem(item)) {
			products.remove(item);
			return true;
		}
		return false;
	}

	/**
	 * Service - find by private key
	 * @param pk - Auto Injected Integer
	 * @return null - method is non-functional
	 */
	@Override
	public OrderEntity findByPk(Integer pk) {
		// TODO Auto-generated method stub
		return null;
	}

		
}
