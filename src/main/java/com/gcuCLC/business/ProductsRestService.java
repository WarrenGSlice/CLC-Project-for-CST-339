package com.gcuCLC.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gcuCLC.model.ProductList;
import com.gcuCLC.model.ProductModel;

@RestController
@RequestMapping("/service")
public class ProductsRestService {
	
	@Autowired
	private ProductsBusinessInterface service;

	@GetMapping(path="/getJson", produces= {MediaType.APPLICATION_JSON_VALUE})
	public List<ProductModel> getProductsAsJson()
	{
		return service.getProducts();
	}
	
	@GetMapping(path="/getXml", produces= {MediaType.APPLICATION_XML_VALUE})
	public ProductList getProductsXml() {
		ProductList productList = new ProductList();
		productList.setProducts(service.getProducts());
		return productList;
	}
}
