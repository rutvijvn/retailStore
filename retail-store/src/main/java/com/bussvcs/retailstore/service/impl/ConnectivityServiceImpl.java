package com.bussvcs.retailstore.service.impl;

import java.util.List;

import javax.sql.DataSource;
import javax.ws.rs.core.Response;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.bussvcs.retailstore.service.ConnectivityService;


/**
 * The Class ConnectivityServiceImpl.
 * @author Rutvij Newaskar
 */
public class ConnectivityServiceImpl implements ConnectivityService{

	/** The data source. */
	@Autowired
	private DataSource dataSource;
		
	/** The jdbc template. */
	private JdbcTemplate jdbcTemplate;
	
	/* (non-Javadoc)
	 * @see com.bussvcs.retailstore.service.ConnectivityService#check()
	 */
	public Response checkConnection(){
		jdbcTemplate = new JdbcTemplate(dataSource);
		final List<Long> list = jdbcTemplate.queryForList("SELECT 1 FROM DUAL", Long.class);
		if(!CollectionUtils.isEmpty(list)){
			return Response.ok("Success").build();
		}else{
			return Response.ok("Failure").build();
		}
		
	}
}
