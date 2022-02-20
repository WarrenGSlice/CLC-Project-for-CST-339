package com.gcuCLC;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//import com.gcuCLC.model.ProductModel;
import com.gcuCLC.business.ProductsBusinessInterface;
import com.gcuCLC.business.ProductsBusinessService;
//import com.gcuCLC.data.DataAccessInterface;
import com.gcuCLC.data.OrderDataService;


@Configuration

public class SpringConfig {

	@Bean(name="productsBusinessService", initMethod="init", destroyMethod="destroy")
	public ProductsBusinessInterface getProductsBusinessServices() {
		return new ProductsBusinessService();
	}
	
	@Bean(name="orderDataService", initMethod="init", destroyMethod="destroy")
	public OrderDataService getOrderDataService() {
		return new OrderDataService();
	}
	
//	@Bean(name="productDataService", initMethod="init", destroyMethod="destroy")
//	public ProductDataService getProductDataService() {
//		return new OrderDataService();
//	}
	
}
