package com.bussvcs.retailstore.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bussvcs.retailstore.data.entity.Product;

/**
 * The Interface ProductRepository.
 * @author Rutvij Newaskar
 */
public interface ProductRepository extends JpaRepository<Product, Long>,
	GenericRepository<Product>{

	/**
	 * Gets the product.
	 *
	 * @param barCode the barCode
	 * @return the product
	 */
	public Product findByBarCode(Long barCode) ; 
}
