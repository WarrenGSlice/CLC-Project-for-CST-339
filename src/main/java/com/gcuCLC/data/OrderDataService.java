package com.gcuCLC.data;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.gcuCLC.entity.OrderEntity;
import com.gcuCLC.repository.EditOrderRepository;
import com.gcuCLC.repository.OrdersRepository;

@Service
public class OrderDataService implements DataAccessInterface<OrderEntity>{

	@Autowired
	private EditOrderRepository editRepo;
	@Autowired
	private OrdersRepository ordersRepository;

	@SuppressWarnings("unused")
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;
	
	/**
	 * Non-Default Constructor for constructor injection
	 */
	public OrderDataService(OrdersRepository ordersRepository, DataSource dataSource) {
		this.ordersRepository = ordersRepository;
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}
	
	public OrderDataService() {
		// TODO Auto-generated constructor stub
	}
	
	

	/**
	 * CRUD: finder to return all order entities
	 */
	@Override
	public List<OrderEntity> findAll() {

		List<OrderEntity> orders = new ArrayList<OrderEntity>();
		try
		{
			// Get all all the Entity Orders
			Iterable<OrderEntity> ordersIterable = ordersRepository.findAll();

			// Convert to a List and return the List
			orders = new ArrayList<OrderEntity>();
			ordersIterable.forEach(orders::add);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		// Return the List
		return orders;
	}
	
	public List<OrderEntity> findByOrderId(Iterable<Long> orderId){
		List<OrderEntity> orders = new ArrayList<OrderEntity>();
		try
		{
			Iterable<OrderEntity> ordersIterable = ordersRepository.findAllById(orderId);
			orders = new ArrayList<OrderEntity>();
			ordersIterable.forEach(orders::add);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return orders;
	}

	@SuppressWarnings("deprecation")
	@Override
	public OrderEntity findById(Integer id) {
		
		String sql = "SELECT * FROM ORDERS WHERE order_id = ?";
		OrderEntity orders = new OrderEntity();
		try
		{
			orders = jdbcTemplateObject.queryForObject(sql, new Object[] {id},(rs, rowNum) -> 
					new OrderEntity((int) rs.getInt("ORDER_ID"),
									rs.getString("COMPANY_NAME"),
									rs.getString("CUSTOMER_NAME"),
									rs.getString("DELIVERY_DATE"),
									(int)rs.getInt("DELIVERY_PRICE"),
									rs.getString("DELIVERY_STATUS"),
									rs.getString("PAYMENT")));
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return (OrderEntity) orders;
	}
	
	@SuppressWarnings("deprecation")
	public OrderEntity findByPk(Integer orderId) {
		OrderEntity ordEnt = null;
		int results = 0;
		String sql= "SELECT COUNT(*) FROM ORDERS WHERE ORDER_ID = ?";
		try
		{
			results = jdbcTemplateObject.queryForObject(sql, new Object[]{orderId}, Integer.class);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

		if (results > 0)
		{
			sql = "SELECT * FROM ORDERS WHERE ORDER_ID = ?";
			try
			{
				ordEnt = (OrderEntity) jdbcTemplateObject.queryForObject(sql, new Object[]{orderId}, (rs, rowNum) ->
					    new OrderEntity((int)rs.getInt("ORDER_ID"),
								rs.getString("COMPANY_NAME"),
								rs.getString("CUSTOMER_NAME"),
								rs.getString("DELIVERY_DATE"),
								(int)rs.getInt("DELIVERY_PRICE"),
								rs.getString("DELIVERY_STATUS"),
								rs.getString("PAYMENT")));
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}

		return ordEnt;
	}
	

	
	@SuppressWarnings("deprecation")
	public Boolean verifyOrder(Integer id) {
		int results = 0;
		String sql = "SELECT COUNT(*) FROM ORDERS WHERE order_id = ?";
		try {
			results = jdbcTemplateObject.queryForObject(sql, new Object[] {id},Integer.class);
		}catch (Exception e) {
			e.printStackTrace();
		}
		if (results == 0) {
			System.out.printf("Order Does not exist: OrderID=%s", id);
			return false;
		}
		else {
			System.out.printf("Order Exists: OrderID=%s", id);
			return true;
		}
	}

	/**
	 * CRUD: create an entity
	 */
	@Override
	public boolean create(OrderEntity orders) {
		// Example of "overriding" the CrudRepository save() because it simple is never called
		// You can inject a dataSource and use the jdbcTemplate to provide a customized implementation of a save() method
		String sql = "INSERT INTO ORDERS(order_id, company_name, customer_name, delivery_date, delivery_price, delivery_status, payment) VALUES(?, ?, ?, ?, ?, ?, ?)";
		try
		{
			// Execute SQL Insert
			jdbcTemplateObject.update(sql,
					orders.getOrderId(),
					orders.getCompanyName(),
					orders.getCustomerName(),
					orders.getDeliveryDate(),
					orders.getDeliveryPrice(),
					orders.getDeliveryStatus(),
					orders.getPayment());
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return false;
		}
	return true;
	}
	
	public String getOrderNo() {
        String sql = "select max(order_id) from orders";
        String orderId = jdbcTemplateObject.queryForObject(sql, String.class);
        if (orderId == null) {
            orderId = (String)("1");
        } else {
            orderId = String.valueOf(Integer.parseInt(orderId) + 1);
        }
        
        orderId.toString();
        return orderId.toString();
    }

	/**
	 * CRUD: Method to Update an Order Entity
	 */
	@Override
	public boolean update(OrderEntity order) {
		
		
		// Return the List
		return ordersRepository.save(order) != null;
	}

	
	
	@Override 
	public boolean delete(OrderEntity t) {
		try
		{
			this.ordersRepository.delete(t);
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
		System.out.println("OrderDataService Initialized");
	}

	@Override
	public void destroy() {
		System.out.println("OrderDataService Destroyed");	
	}
	
	public List<OrderEntity> getOrderByOrderId(Integer id){
		return editRepo.findByOrderId(id);
	}

	public List<OrderEntity> getOrderByCompanyName(String companyName){
		return editRepo.findByCompanyName(companyName);
	}

}
