package com.bussvcs.retailstore.service;

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

import com.bussvcs.retailstore.data.entity.Bill;
import com.bussvcs.retailstore.data.entity.Product;
import com.bussvcs.retailstore.data.entity.ProductCategory;
import com.bussvcs.retailstore.data.entity.User;
import com.bussvcs.retailstore.data.repository.BillRepository;
import com.bussvcs.retailstore.data.repository.ProductRepository;
import com.bussvcs.retailstore.exception.CustomException;
import com.bussvcs.retailstore.valueobjects.BillDetails;
import com.bussvcs.retailstore.valueobjects.CartProduct;

/**
 * The Class BillingServiceTest.
 * @author Rutvij Newaskar
 */
@RunWith(PowerMockRunner.class)
@ContextConfiguration(locations ={"classpath:META-INF/test-context.xml"})
@PowerMockRunnerDelegate(SpringJUnit4ClassRunner.class)
public class BillingServiceTest {

	/** The bill service. */
	@Autowired
	@Qualifier("billingServiceImpl")
	private BillingService billService;
	
	/** The product repository. */
	@Autowired
	private ProductRepository productRepository;
	
	/** The bill repository. */
	@Autowired
	private BillRepository billRepository;
	
	/**
	 * Test generate bill.
	 */
	@Test
	public void testGenerateBill() {
		BillDetails billDetails = new BillDetails();
		User user = new User();
		user.setEmail("rutvij.cse@gmail.com");
		user.setFirstName("Rutvij");
		user.setLastName("Newaskar");
		user.setMobileNumber("9930399836");
		billDetails.setUser(user);
		
		CartProduct cartProduct1 = new CartProduct();
		cartProduct1.setProductId(1);
		cartProduct1.setQuantity(2);		
		billDetails.getProductList().add(cartProduct1);
		
		CartProduct cartProduct2 = new CartProduct();
		cartProduct2.setProductId(2);
		cartProduct2.setWeight(750);
		billDetails.getProductList().add(cartProduct2);
		
		CartProduct cartProduct3 = new CartProduct();
		cartProduct3.setProductId(3);
		cartProduct3.setQuantity(5);
		billDetails.getProductList().add(cartProduct3);
		
		ProductCategory categoryA = new ProductCategory();
		categoryA.setProductCategoryId(1l);
		categoryA.setCategoryName("A");
		categoryA.setDiscount(10);
		categoryA.setServiceTax(20);
		ProductCategory categoryB = new ProductCategory();
		categoryB.setProductCategoryId(2l);
		categoryB.setCategoryName("B");
		categoryB.setDiscount(0);
		categoryB.setServiceTax(10);
		ProductCategory categoryC = new ProductCategory();
		categoryC.setProductCategoryId(3l);
		categoryC.setCategoryName("C");
		categoryC.setDiscount(20);
		categoryC.setServiceTax(0);
		
		Product product1 = new Product();
		product1.setProductId(1l);
		product1.setProductName("One");
		product1.setBasePrice(100);
		product1.setDiscount(10);
		product1.setProductCategory(categoryA);
		Product product2 = new Product();
		product2.setProductId(2l);
		product2.setProductName("Two");
		product2.setBasePrice(500);
		product2.setDiscount(50);
		product2.setWeight(1000);
		product2.setProductCategory(categoryB);
		Product product3 = new Product();
		product3.setProductId(1l);
		product3.setProductName("Three");
		product3.setBasePrice(400);
		product3.setDiscount(15);
		product3.setProductCategory(categoryB);
		Product product4 = new Product();
		product4.setProductId(1l);
		product4.setProductName("Four");
		product4.setBasePrice(300);
		product4.setDiscount(9);
		product4.setProductCategory(categoryC);
		
		EasyMock.expect(productRepository.findOne(1l)).andReturn(product1);
		EasyMock.expect(productRepository.findOne(2l)).andReturn(product2);
		EasyMock.expect(productRepository.findOne(3l)).andReturn(product3);
		EasyMock.expect(productRepository.findOne(4l)).andReturn(product4);
		EasyMock.expect(billRepository.persist(EasyMock.anyObject(Bill.class))).andReturn(new Bill());		
		PowerMock.replayAll();
		try {
			billService.generateBill(billDetails);
		} catch (CustomException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
