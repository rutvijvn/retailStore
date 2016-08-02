package com.bussvcs.retailstore.service.impl;

import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.bussvcs.retailstore.exception.CustomException;
import com.bussvcs.retailstore.helper.BillingHelper;
import com.bussvcs.retailstore.service.BillingService;
import com.bussvcs.retailstore.valueobjects.BillDetails;


/**
 * The Class BillingServiceImpl.
 * @author Rutvij Newaskar
 */
@Service("billingServiceImpl")
@Transactional
public class BillingServiceImpl implements BillingService {

	/** The billing helper. */
	@Autowired
	BillingHelper billingHelper;
	
	/* (non-Javadoc)
	 * @see com.bussvcs.retailstore.service.BillingService#generateBill(com.bussvcs.retailstore.valueobjects.BillDetails)
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public Response generateBill(final BillDetails billDetails) throws CustomException {
		billingHelper.generateBill(billDetails);	
		return Response.ok().build();
	}

}
