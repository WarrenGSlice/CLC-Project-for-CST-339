package com.gcuCLC.data;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.gcuCLC.entity.ProductsEntity;
import com.gcuCLC.repository.ProductsRepository;


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

	@Override
	public void init() {
		System.out.println("ProductDataService Initialized");
	}

	@Override
	public void destroy() {
		System.out.println("ProductDataService Destroyed");	
	}

	
//	public void insert(OrderEntity orderEntity)
//	{
//		String sql = "INSERT INTO ORDERS " + "(CUSTOMER_NAME, ORDER, DELIVERY_DATE, DELIVERY_PRICE, PAYMENT, DELIVERY_STATUS) VALUES (?, ?, ?, ?, ?, ?)";
//		KeyHolder holder = new GeneratedKeyHolder();
//		jdbcTemplateObject.update(new PreparedStatementCreator())
//		{
//			@Override
//			public PreparedStatement createdPreparedStatement(Connection connection) throws SQLException
//			{
//				PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
//				ps.setString(1, orderEntity.getCustomerName());
//				ps.setString(2, orderEntity.getOrder());
//				ps.setString(3, orderEntity.getDeliveryDate());
//				ps.setFloat(4, orderEntity.getDeliveryPrice());
//				ps.setString(5, orderEntity.getPayment());
//				ps.setString(6, orderEntity.getDeliveryStatus());
//				return ps;
//			}
//		}, holder);
//
//		int generatedOrderId = holder.getKey().intValue();
//		System.out.println("generatedOrderId = " + generatedOrderId);
//	}
}
