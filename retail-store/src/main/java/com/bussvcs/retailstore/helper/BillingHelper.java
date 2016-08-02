package com.bussvcs.retailstore.helper;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bussvcs.retailstore.data.entity.Bill;
import com.bussvcs.retailstore.data.entity.BillItem;
import com.bussvcs.retailstore.data.entity.Product;
import com.bussvcs.retailstore.data.repository.BillRepository;
import com.bussvcs.retailstore.data.repository.ProductRepository;
import com.bussvcs.retailstore.exception.CustomException;
import com.bussvcs.retailstore.valueobjects.BillDetails;
import com.bussvcs.retailstore.valueobjects.CartProduct;

/**
 * The Class BillingHelper.
 * @author Rutvij Newaskar
 */
@Component
public class BillingHelper {

	/** The product repository. */
	@Autowired
	private ProductRepository productRepository;
	
	/** The bill repository. */
	@Autowired
	private BillRepository billRepository; 

	/**
	 * Generate bill.
	 *
	 * @param billDetails the bill details
	 * @throws CustomException the custom exception
	 */
	public void generateBill(final BillDetails billDetails) throws CustomException {
		List<CartProduct> productList = billDetails.getProductList();
		Bill bill = new Bill();
		bill.setUser(billDetails.getUser());		
		
		float totalSum = 0 ;
		float totalserviceTax = 0;
		float totalDiscount = 0;	
		
		for (CartProduct cartProduct : productList) {
			Product product = productRepository.findOne(cartProduct.getProductId());
			if(null == product){
				throw new CustomException("Product Not Present");
			}
			BillItem billItem = new BillItem();
			billItem.setProduct(product);
			
			int quantity = cartProduct.getQuantity();
			int weight = Math.round(cartProduct.getWeight());
			float totalPrice = 0;
			if(quantity > 0){
				totalPrice = calculateTotalPrice(product.getBasePrice(), quantity);
				billItem.setQuantity(quantity);
			}else if (weight > 0){
				totalPrice = calculateTotalPrice(product.getBasePrice(), weight, product.getWeight());
				billItem.setWeight(weight);
			}			
			float productDiscount = calculatePercentageAmount(totalPrice, product.getDiscount());
			float categoryDiscount = calculatePercentageAmount(totalPrice, product.getProductCategory().getDiscount());
			float serviceTax = calculatePercentageAmount(totalPrice, product.getProductCategory().getServiceTax());
			
			totalSum = totalSum +  totalPrice;
			totalserviceTax = totalserviceTax + serviceTax;
			totalDiscount = totalDiscount + productDiscount + categoryDiscount;
			
			billItem.setBasePrice(totalPrice);
			billItem.setProductDiscount(productDiscount);
			billItem.setCategoryDiscount(categoryDiscount);
			billItem.setServiceTax(serviceTax);
			billItem.setBill(bill);
			bill.getBillItems().add(billItem);			
		}
		
		float billAmount = totalSum - totalDiscount + totalserviceTax;
		bill.setTotalSum(totalSum);
		bill.setTotalDiscount(totalDiscount);
		bill.setServiceTax(totalserviceTax);
		bill.setBillAmount(billAmount);
		billRepository.persist(bill);
	}
	
	/**
	 * Calculate total price.
	 *
	 * @param basePrice the base price
	 * @param quantity the quantity
	 * @return the float
	 */
	private float calculateTotalPrice(float basePrice, float quantity) {
		return basePrice * quantity;			
	}
	
	/**
	 * Calculate total price.
	 *
	 * @param basePrice the base price
	 * @param weight the weight
	 * @param perWeight the per weight
	 * @return the float
	 */
	private float calculateTotalPrice(float basePrice, float weight, int perWeight) {		
		return (basePrice/perWeight) * weight;				
	}

	/**
	 * Calculate percentage amount.
	 *
	 * @param baseAmount the base amount
	 * @param percentage the percentage
	 * @return the float
	 */
	private float calculatePercentageAmount(float baseAmount, float percentage) {
		return (baseAmount * percentage)/100;

	}
}
