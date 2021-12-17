package com.abhi.springweb;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;
import com.abhi.springweb.entities.Product;

@SpringBootTest
class SpringrestapiApplicationTests {

	@Test
	void testGetProduct() 
	{
		RestTemplate restTemplate=new RestTemplate();
		Product product=restTemplate.getForObject("http://localhost:8080/productapi/products/1",Product.class);
		assertNotNull(product);
		assertEquals("Iphone",product.getName());
	}
	
	@Test
	public void testCreateProduct() {
		RestTemplate restTemplate=new RestTemplate();
		Product product=new Product();
		product.setName("Samsung Mobile");
		product.setDescription("Its Awesome");
		product.setPrice((long) 20000);
		Product newProduct=restTemplate.postForObject("http://localhost:8080/productapi/products/",product,Product.class);
		assertNotNull(newProduct);
		assertNotNull(newProduct.getId());
		assertEquals("Samsung Mobile",newProduct.getName());
	}
	
	@Test
	void testUpdateProduct() {
	RestTemplate restTemplate=new RestTemplate();
	Product product=restTemplate.getForObject("http://localhost:8080/productapi/products/1",Product.class);
	product.setPrice((long) 15000);
	restTemplate.put("http://localhost:8080/productapi/products/",product);
	}
}
