package com.bussvcs.retailstore.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Service;

import com.bussvcs.retailstore.exception.CustomException;

/**
 * The Service Interface ProductService.
 * @author Rutvij Newaskar
 */
@Service
public interface ProductService {

	/**
	 * Method to get the product based on barcode.
	 *
	 * @param barCode the bar code
	 * @return the product
	 */
	@GET
	@Path("/getProduct")	
	@Produces(MediaType.APPLICATION_JSON)
	public Response getProduct(@QueryParam("barcode") final Long barCode);
	
	/**
	 * Gets the product id.
	 *
	 * @param barCode the bar code
	 * @return the product id
	 * @throws CustomException the custom exception
	 */
	@GET
	@Path("/getProductId")	
	@Produces(MediaType.APPLICATION_JSON)
	public Response getProductId(@QueryParam("barcode") final Long barCode) throws CustomException;
	
	
	
}
