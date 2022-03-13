package com.gcuCLC.business;

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
 * 1. Interface - Products Business Interface
 * ---------------------------------------------------------------------------
 * Modification History:
 * Date     Name                Comment
 * -------- ------------------- ----------------------------------------------
 * 01/18/2022 Team                Initial Creation
 *
 *
 */

public interface ProductsBusinessInterface {
	
	/**
	 * Method to run Console Test's
	 */
	public void test();

	/**
	 * Method to initiate bean instance
	 */
	public void init();
	
	/**
	 * Method to Destroy Bean Instance
	 */
	public void destroy();
	
	/**
	 * Method to Get List of Products
	 * @return - List of Products
	 */
	public List<ProductModel> getProducts();
	
	/**
	 * Method to Add Products
	 * @param item - Full Order of ProductModel type
	 * @return - New Order entry in Product List
	 */
	public List<ProductModel> AddItem(ProductModel item);

	/**
	 * Method to Add Items
	 * @param items - Auto Injected List of String Array items
	 * Non-Functional
	 */
	void AddItems(List<String[]> items);

	/**
	 * Method to see if Item Contains Item
	 * @param item - Property of ProductModel
	 * @return Full Item - If Item contains Item
	 * Method is non-functional
	 */
	boolean ContainsItem(ProductModel item);
	
	/**
	 * Method for Removing Orders
	 * @param item - Full Order
	 * @return - Order is Removed From Database
	 */
	boolean RemoveItem(ProductModel item);

	/**
	 * Method to find Order by Primary Key in Database
	 * @param pk - Order Id
	 * @return Full Order by Order Id
	 * Method is non-functional
	 */
	OrderEntity findByPk(Integer pk);

}
