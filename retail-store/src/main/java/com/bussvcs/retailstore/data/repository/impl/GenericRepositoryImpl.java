package com.bussvcs.retailstore.data.repository.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.data.repository.NoRepositoryBean;

import com.bussvcs.retailstore.data.repository.GenericRepository;

/**
 * The Class GenericRepositoryImpl.
 *
 * @param <T> the generic type
 * @author Rutvij Newaskar
 */
@NoRepositoryBean
public class GenericRepositoryImpl<T extends Serializable> implements GenericRepository<T>{
	/** The manager. */
	@PersistenceContext
    private EntityManager manager;

	/* (non-Javadoc)
	 * @see com.bussvcs.retailstore.data.repository.GenericRepository#persist(java.io.Serializable)
	 */
	@Override
	public T persist(T domainObject) {
		this.manager.persist(domainObject);
		return domainObject;
	}
	
	/* (non-Javadoc)
	 * @see com.bussvcs.retailstore.data.repository.GenericRepository#executeQuery(java.lang.String, java.util.Map, java.lang.Class)
	 */
	@Override
	public List<T> executeQuery(String sqlQuery, Map<String, Object> queryParam, Class<T> entityType) {
		TypedQuery<T> query = this.manager.createQuery(sqlQuery, entityType);
		for (Entry<String, Object> queryParamObject : queryParam.entrySet()) {
			query.setParameter(queryParamObject.getKey(), queryParamObject.getValue());
		}
		return query.getResultList();		
	}
	
	/* (non-Javadoc)
	 * @see com.bussvcs.retailstore.data.repository.GenericRepository#executeQuerySingle(java.lang.String, java.util.Map, java.lang.Class)
	 */
	@Override
	public T executeQuerySingle(String sqlQuery, Map<String, Object> queryParam, Class<T> entityType) {
		TypedQuery<T> query = this.manager.createQuery(sqlQuery, entityType).setMaxResults(1);
		for (Entry<String, Object> queryParamObject : queryParam.entrySet()) {
			query.setParameter(queryParamObject.getKey(), queryParamObject.getValue());
		}
		List<T> resultList = query.getResultList();		
		if(CollectionUtils.isNotEmpty(resultList)){
			return resultList.get(0);
		}
		return null;
	} 
	


}
