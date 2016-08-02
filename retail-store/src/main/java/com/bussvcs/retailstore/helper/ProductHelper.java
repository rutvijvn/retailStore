package com.bussvcs.retailstore.helper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bussvcs.retailstore.data.entity.Product;
import com.bussvcs.retailstore.data.repository.ProductRepository;
import com.bussvcs.retailstore.exception.CustomException;

/**
 * Helper class for ProductService.
 * @author Rutvij Newaskar
 */

@Component
public class ProductHelper {
	
	/** The product repository. */
	@Autowired
	private ProductRepository productRepository;
	
	/**
	 * Gets the product from barcode.
	 *
	 * @param barCode the bar code
	 * @return the product from barcode
	 */
	public Product getProductFromBarcode(Long barCode){
		return productRepository.findByBarCode(barCode);
	}
	
	/**
	 * Gets the product id from barcode.
	 *
	 * @param barCode the bar code
	 * @return the product id from barcode
	 * @throws CustomException the custom exception
	 */
	public Long getProductIdFromBarcode(Long barCode) throws CustomException{
		Product product = productRepository.findByBarCode(barCode);
		if(null != product){
			return product.getProductId();
		}else{
			throw new CustomException("Product Not Present");
		}
		
	}
	
}
