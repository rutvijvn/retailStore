package com.bussvcs.retailstore.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Service;

/**
 * The Interface ConnectivityService.
 * @author Rutvij Newaskar
 */
@Service
public interface ConnectivityService {

	/**
	 * Check.
	 *
	 * @return the response
	 */
	@GET	
	@Path("/connectivitycheck")
	@Produces(MediaType.APPLICATION_JSON)
	public Response checkConnection();
	
}