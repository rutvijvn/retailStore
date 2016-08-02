package com.bussvcs.retailstore.data.repository;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.springframework.data.repository.NoRepositoryBean;

/**
 * The Interface GenericRepository.
 *
 * @param <T> the generic type
 * @author Rutvij Newaskar
 */
@NoRepositoryBean
public interface GenericRepository<T extends Serializable> {

	/**
	 * Persist.
	 *
	 * @param domainObject the domain object
	 * @return the t
	 */
	public T persist(T domainObject);

	/**
	 * Execute query.
	 *
	 * @param sqlQuery the sql query
	 * @param queryParam the query param
	 * @param entityType the entity type
	 * @return the list
	 */
	public List<T> executeQuery(String sqlQuery, Map<String, Object> queryParam, Class<T> entityType);
	
	/**
	 * Execute query single.
	 *
	 * @param sqlQuery the sql query
	 * @param queryParam the query param
	 * @param entityType the entity type
	 * @return the t
	 */
	public T executeQuerySingle(String sqlQuery, Map<String, Object> queryParam, Class<T> entityType);
}
