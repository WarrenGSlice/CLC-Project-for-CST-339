package com.gcuCLC.data;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.gcuCLC.entity.OrderEntity;
import com.gcuCLC.entity.ProductImageEntity;
import com.gcuCLC.entity.ProductsEntity;
import com.gcuCLC.repository.ProductImageRepository;

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
	 * Non-Default Constructor for constructor injection
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
	 * CRUD: Method to Update an Order Entity
	 */
	@Override
	public boolean update(ProductImageEntity productPhoto) {
		
		
		// Return the List
		return productImageRepository.save(productPhoto) != null;
	}

	/**
	 * CRUD: Method to Delete an Order Entity
	 * @param order
	 * @return
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

	@Override
	public Optional<ProductImageEntity> findProductImagesByProductId(ProductsEntity id) {
		Integer photoId = id.getProductId();
		return Optional.of(ProductImageDAO.findById(photoId));
	}
	
	@Override
	public void init() {
		System.out.println("ProductImageDataService Initialized");
	}

	@Override
	public void destroy() {
		System.out.println("ProductImageDataService Destroyed");	
	}


	
}