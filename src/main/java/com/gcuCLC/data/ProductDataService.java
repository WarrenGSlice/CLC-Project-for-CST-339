package com.gcuCLC.data;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.gcuCLC.entity.ProductsEntity;
import com.gcuCLC.repository.ProductsRepository;

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
 * 1. Data Service - Product Data Service
 * ---------------------------------------------------------------------------
 * Modification History:
 * Date     Name                Comment
 * -------- ------------------- ----------------------------------------------
 * 01/18/2022 Team                Initial Creation
 *
 *
 */

public class ProductDataService implements DataAccessInterface<ProductsEntity> {

	@Autowired
	private ProductsRepository productsRepository;
	@Autowired
	private DataAccessInterface<ProductsEntity> ProductDAO;
	@SuppressWarnings("unused")
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;
	
	/**
	 * Non-Default Constructor for constructor injection
	 * @param productsRepository - Auto Injected Products Repository Repository
	 * @param dataSource - Auto Injected Data Source
	 */
	public ProductDataService(ProductsRepository productsRepository, DataSource dataSource) {
		this.productsRepository = productsRepository;
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}
	
	/**
	 * CRUD: finder to return all Product entities
	 */
	@Override
	public List<ProductsEntity> findAll() {
		List<ProductsEntity> products = new ArrayList<ProductsEntity>();
		try
		{
			// Get all all the Entity Orders
			Iterable<ProductsEntity> productsIterable = productsRepository.findAll();

			// Convert to a List and return the List
			products = new ArrayList<ProductsEntity>();
			productsIterable.forEach(products::add);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		// Return the List
		return products;
	}

	/**
	 * Method to find Products by Id
	 */
	@Override
	public ProductsEntity findById(Integer id) {
		// TODO Auto-generated method stub
		return ProductDAO.findById(id);
	}

	/**
	 * CRUD: create an entity
	 */
	@Override
	public boolean create(ProductsEntity product) {
		// Example of "overriding" the CrudRepository save() because it simple is never called
		// You can inject a dataSource and use the jdbcTemplate to provide a customized implementation of a save() method
		String sql = "INSERT INTO ORDERS(PRODUCT_ID, PRODUCT_NAME, BRAND, DETAILS, PRODUCT_PRICE, COLOR) VALUES(?, ?, ?, ?, ?, ?)";
		try
		{
			// Execute SQL Insert
			jdbcTemplateObject.update(sql,
					product.getProductId(),
					product.getProductName(),
					product.getBrand(),
					product.getDetails(),
					product.getProductPrice(),
					product.getColor());
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return false;
		}
	return true;
	}

	/**
	 * CRUD: Method to Update an Product Entity
	 */
	@Override
	public boolean update(ProductsEntity product) {

		// Return the List
		return productsRepository.save(product) != null;
	}

	/**
	 * CRUD: Method to Delete a Product Entity
	 */
	@Override
	public boolean delete(ProductsEntity product) {
		try
		{
			this.productsRepository.delete(product);
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return false;
			
		}
		// Return the List
		return true;
	}

	/**
	 * Method to tell Console when Service is initialized
	 */
	@Override
	public void init() {
		System.out.println("ProductDataService Initialized");
	}

	/**
	 * Method to tell Console when service is Destroyed
	 */
	@Override
	public void destroy() {
		System.out.println("ProductDataService Destroyed");	
	}

}
