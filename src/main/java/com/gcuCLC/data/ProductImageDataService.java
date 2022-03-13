package com.gcuCLC.data;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import com.gcuCLC.entity.ProductImageEntity;
import com.gcuCLC.entity.ProductsEntity;
import com.gcuCLC.repository.ProductImageRepository;

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
 * 1. Data Service - Product Image Data Service
 * ---------------------------------------------------------------------------
 * Modification History:
 * Date     Name                Comment
 * -------- ------------------- ----------------------------------------------
 * 01/18/2022 Team                Initial Creation
 *
 *
 */

public class ProductImageDataService implements DataAccessInterface<ProductImageEntity>, DataAccessProductImageInterface<ProductImageEntity>{

	@SuppressWarnings("unused")
	@Autowired
	private DataAccessInterface<ProductsEntity> productDAO;
	@Autowired
	private DataAccessInterface<ProductImageEntity> ProductImageDAO;
	@Autowired
	private ProductImageRepository productImageRepository;
	@SuppressWarnings("unused")
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;
	
	/**
	 * Non-Default Constructor for constructor Injection
	 * @param productImageRepository - Auto Injected Product Image Repository Repository
	 * @param dataSource - Auto Injected Data Source
	 */
	public ProductImageDataService(ProductImageRepository productImageRepository, DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
		this.productImageRepository = productImageRepository;
	}
	
	/**
	 * CRUD: finder to return all product photo entities
	 */
	@Override
	public List<ProductImageEntity> findAll() {

		List<ProductImageEntity> productPhoto = new ArrayList<ProductImageEntity>();
		try
		{
			// Get all all the Entity Orders
			Iterable<ProductImageEntity> productPhotoIterable = productImageRepository.findAll();

			// Convert to a List and return the List
			productPhoto = new ArrayList<ProductImageEntity>();
			productPhotoIterable.forEach(productPhoto::add);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		// Return the List
		return productPhoto;
	}

	/**
	 * Method to Find Product Image by Id
	 */
	@Override
	public ProductImageEntity findById(Integer id) {
		// TODO Auto-generated method stub
		return ProductImageDAO.findById(id);
	}

	/**
	 * CRUD: create an entity
	 */
	@Override
	public boolean create(ProductImageEntity productPhoto) {
		// Example of "overriding" the CrudRepository save() because it simple is never called
		// You can inject a dataSource and use the jdbcTemplate to provide a customized implementation of a save() method
		String sql = "INSERT INTO ORDERS(ID, PRODUCT_IMAGE_NAME, PRODUCT_IMAGE_URL) VALUES(?, ?, ?)";
		try
		{
			// Execute SQL Insert
			jdbcTemplateObject.update(sql,
					productPhoto.getId(),
					productPhoto.getProductImageName(),
					productPhoto.getProductImageUrl());
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return false;
		}
	return true;
	}

	/**
	 * CRUD: Method to Update a Product Image
	 */
	@Override
	public boolean update(ProductImageEntity productPhoto) {
		
		
		// Return the List
		return productImageRepository.save(productPhoto) != null;
	}

	/**
	 * CRUD: Method to Delete an Order Entity
	 * @param productPhoto - Auto Injected Product Image Entity Entity
	 * @return - Deleted Image
	 */
	@Override
	public boolean delete(ProductImageEntity productPhoto) {
		try
		{
			this.productImageRepository.delete(productPhoto);
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
	 * Method to Find The Product Image By the Product Id
	 */
	@Override
	public Optional<ProductImageEntity> findProductImagesByProductId(ProductsEntity id) {
		Integer photoId = id.getProductId();
		return Optional.of(ProductImageDAO.findById(photoId));
	}
	
	/**
	 * Method to tell Console When Service is initialized
	 */
	@Override
	public void init() {
		System.out.println("ProductImageDataService Initialized");
	}

	/**
	 * Method to tell Console when Service is destroyed
	 */
	@Override
	public void destroy() {
		System.out.println("ProductImageDataService Destroyed");	
	}


	
}