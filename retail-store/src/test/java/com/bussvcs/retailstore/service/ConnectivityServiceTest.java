package com.bussvcs.retailstore.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.modules.junit4.PowerMockRunnerDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(PowerMockRunner.class)
@ContextConfiguration(locations ={"classpath:META-INF/test-context.xml"})
@PowerMockRunnerDelegate(SpringJUnit4ClassRunner.class)
public class ConnectivityServiceTest {
	
	@Autowired
	private ConnectivityService connectivityService;

	@Test
	public void testCheckConnection(){
		connectivityService.checkConnection();
	}
}