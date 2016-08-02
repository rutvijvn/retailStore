package com.bussvcs.retailstore.util;

import java.util.List;

import javax.sql.DataSource;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;

// TODO: Auto-generated Javadoc
/**
 * The Class ProjectSetup. This class creates All required database tables and
 * their constraints (Foreign keys) and empty all tables and insert few product
 * categories and products for testing purpose
 * 
 * @author Rutvij Newaskar
 */
public class ProjectSetup {

	/**
	 * The main method.
	 *
	 * @param args
	 *            the arguments
	 */
	public static void main(String[] args) {

		boolean clearAllAndInsert = true;
		ApplicationContext appContext = new ClassPathXmlApplicationContext("META-INF/retail-store-beans.xml");
		DataSource dataSource = (DataSource) appContext.getBean("dataSource");
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		StringBuilder checkSql = new StringBuilder();
		checkSql.append("SELECT COUNT(*) FROM INFORMATION_SCHEMA.TABLES WHERE ")
				.append("(TABLE_SCHEMA = 'RETAILSTORE' AND TABLE_NAME = 'BILL') ")
				.append("OR (TABLE_SCHEMA = 'RETAILSTORE' AND TABLE_NAME = 'BILL_ITEM') ")
				.append("OR (TABLE_SCHEMA = 'RETAILSTORE' AND TABLE_NAME = 'PRODUCT') ")
				.append("OR (TABLE_SCHEMA = 'RETAILSTORE' AND TABLE_NAME = 'PRODUCT_CATEGORY') ")
				.append("OR (TABLE_SCHEMA = 'RETAILSTORE' AND TABLE_NAME = 'USER'); ");

		final List<Long> list = jdbcTemplate.queryForList(checkSql.toString(), Long.class);
		if (CollectionUtils.isEmpty(list) || (!CollectionUtils.isEmpty(list) && list.get(0) != 5)) {
			Resource resource = new ClassPathResource("SQL/project-setup-queries.sql");
			ResourceDatabasePopulator databasePopulator = new ResourceDatabasePopulator(resource);
			databasePopulator.execute(dataSource);
			System.out.println("Tables Created");
		}

		if (clearAllAndInsert) {
			Resource resource = new ClassPathResource("SQL/clear-all-data.sql");
			ResourceDatabasePopulator databasePopulator = new ResourceDatabasePopulator(resource);
			databasePopulator.execute(dataSource);
			System.out.println("Data Deleted");
			Resource resource1 = new ClassPathResource("SQL/insert-data.sql");
			ResourceDatabasePopulator databasePopulator1 = new ResourceDatabasePopulator(resource1);
			databasePopulator1.execute(dataSource);
			System.out.println("Data Inserted");
		}

	}

}