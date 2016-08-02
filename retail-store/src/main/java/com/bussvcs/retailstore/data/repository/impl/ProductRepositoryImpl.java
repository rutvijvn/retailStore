package com.bussvcs.retailstore.data.repository.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

import com.bussvcs.retailstore.data.entity.Product;

/**
 * The Class ProductRepositoryImpl.
 * @author Rutvij Newaskar
 */

public class ProductRepositoryImpl 
extends GenericRepositoryImpl<Product>
{
	
	/**
	 * Find by barcode.
	 *
	 * @param barCode the bar code
	 * @return the product
	 */
	public Product findByBarCode(Long barCode){
		StringBuilder sqlBuilder = new StringBuilder();
		sqlBuilder.append("select prod from Product prod");
		sqlBuilder.append(" where prod.barCode = :barCode");
		
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("barCode", barCode);
		
		return super.executeQuerySingle(sqlBuilder.toString(), paramMap, Product.class);	
		
	}
}
