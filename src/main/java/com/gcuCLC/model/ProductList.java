package com.gcuCLC.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

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
 * 1. Model - Product List
 * ---------------------------------------------------------------------------
 * Modification History:
 * Date     Name                Comment
 * -------- ------------------- ----------------------------------------------
 * 01/18/2022 Team                Initial Creation
 *
 *
 */

@XmlRootElement(name="products")
public class ProductList {
	
	private List<ProductModel> products = new ArrayList<>();

	/**
	 * Method to Get All Products in XML
	 * @return All Products in XML format
	 */
	@XmlElement(name="product")
	public List<ProductModel> getProducts()
	{
		return this.products;
	}
	
	/**
	 * Setter - Sets all products into a list for viewing
	 * @param products - List of Product Model type
	 */
	public void setProducts(List<ProductModel> products)
	{
		this.products = products;
	}

	/**
	 * Product List toString Method
	 */
	@Override
	public String toString() {
		return "ProductList [products=" + products + "]";
	}
	
	
}
