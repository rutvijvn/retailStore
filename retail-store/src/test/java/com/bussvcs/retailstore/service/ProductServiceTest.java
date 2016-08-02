package com.bussvcs.retailstore.service;

import java.util.ArrayList;
import java.util.List;

import org.easymock.EasyMock;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.easymock.PowerMock;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.modules.junit4.PowerMockRunnerDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bussvcs.retailstore.data.entity.Product;
import com.bussvcs.retailstore.data.repository.ProductRepository;


/**
 * The Class ProductServiceTest.
 * @author Rutvij Newaskar
 */
@RunWith(PowerMockRunner.class)
@ContextConfiguration(locations ={"classpath:META-INF/test-context.xml"})
@PowerMockRunnerDelegate(SpringJUnit4ClassRunner.class)
public class ProductServiceTest {

	/** The product service. */
	@Autowired
	@Qualifier("productServiceImpl")
	private ProductService productService;
	
	/** The product repository. */
	@Autowired
	private ProductRepository productRepository;
	
	/**
	 * Test get product.
	 */
	@Test
	public void testGetProduct(){
		Long barCode = 123456789l;
		
		Product product = new Product();
		product.setProductId(123l);
		product.setBarCode(1234567891l);
		product.setProductName("prodName");
		
		List<Object> products = new ArrayList<>();
		products.add(product);
		
		
		EasyMock.expect(productRepository.findByBarCode(barCode)).andReturn(product);		
		PowerMock.replayAll();
		productService.getProduct(barCode);
	}

}
