package com.bussvcs.retailstore.service.impl;

import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.bussvcs.retailstore.exception.CustomException;
import com.bussvcs.retailstore.helper.ProductHelper;
import com.bussvcs.retailstore.service.ProductService;

/**
 * The Implementation Class of ProductSerivce .
 * @author Rutvij Newaskar
 */
@Service("productServiceImpl")
@Transactional
public class ProductServiceImpl implements ProductService{

	/** The product helper. */
	@Autowired
	private ProductHelper productHelper;
	
	/* (non-Javadoc)
	 * @see com.bussvcs.retailstore.service.ProductService#getProduct(java.lang.String)
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public Response getProduct(Long barCode) {
		return Response.ok(productHelper.getProductFromBarcode(barCode)).build();
	}

	/* (non-Javadoc)
	 * @see com.bussvcs.retailstore.service.ProductService#getProductId(java.lang.Long)
	 */
	@Override
	public Response getProductId(Long barCode) throws CustomException {
		return Response.ok(productHelper.getProductIdFromBarcode(barCode)).build();
	}

}
