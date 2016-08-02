package com.bussvcs.retailstore.service;

import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Service;

import com.bussvcs.retailstore.exception.CustomException;
import com.bussvcs.retailstore.valueobjects.BillDetails;

/**
 * The Interface BillingService.
 * @author Rutvij Newaskar
 */
@Service
public interface BillingService {

	/**
	 * Generate bill.
	 *
	 * @param billDetails the bill details
	 * @throws CustomException the custom exception
	 */
	@PUT
	@Path("/generateBill")	
	@Produces(MediaType.APPLICATION_JSON)
	public Response generateBill(final BillDetails billDetails) throws CustomException;
	
}
