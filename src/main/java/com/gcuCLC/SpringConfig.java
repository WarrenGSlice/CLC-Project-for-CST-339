package com.gcuCLC;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.boot.actuate.autoconfigure.endpoint.web.CorsEndpointProperties;
import org.springframework.boot.actuate.autoconfigure.endpoint.web.WebEndpointProperties;
import org.springframework.boot.actuate.autoconfigure.web.server.ManagementPortType;
import org.springframework.boot.actuate.endpoint.ExposableEndpoint;
import org.springframework.boot.actuate.endpoint.web.EndpointLinksResolver;
import org.springframework.boot.actuate.endpoint.web.EndpointMapping;
import org.springframework.boot.actuate.endpoint.web.EndpointMediaTypes;
import org.springframework.boot.actuate.endpoint.web.ExposableWebEndpoint;
import org.springframework.boot.actuate.endpoint.web.WebEndpointsSupplier;
import org.springframework.boot.actuate.endpoint.web.annotation.ControllerEndpointsSupplier;
import org.springframework.boot.actuate.endpoint.web.annotation.ServletEndpointsSupplier;
import org.springframework.boot.actuate.endpoint.web.servlet.WebMvcEndpointHandlerMapping;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.util.StringUtils;

import com.gcuCLC.data.DataAccessInterface;
import com.gcuCLC.entity.OrderEntity;





@Configuration

public class SpringConfig {

//	@Bean(name="productsBusinessService", initMethod="init", destroyMethod="destroy")
//	public ProductsBusinessInterface getProductsBusinessServices() {
//		return new ProductsBusinessService();
//	}
	
//	@Bean(name="orderDataService", initMethod="init", destroyMethod="destroy")
//	public OrderDataService getOrderDataService() {
//		return new OrderDataService();
//	}
	
//	@Bean(name="userBusinessService", initMethod="init", destroyMethod="destroy")
//	public DataAccessUserInterface<UserEntity> getUserDataService() {
//		return (DataAccessUserInterface<UserEntity>) new UserBusinessService();
//	}

//	@Bean(name="dataAccessInterface", initMethod="init", destroyMethod="destroy")
//	public DataAccessInterface<OrderEntity> getUserDataService() {
//		return  new DataAccessInterface();
//	}

}
