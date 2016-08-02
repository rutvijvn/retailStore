package com.bussvcs.retailstore.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bussvcs.retailstore.data.entity.Bill;

/**
 * The Interface BillRepository.
 * @author Rutvij Newaskar
 */
public interface BillRepository extends JpaRepository<Bill, Long>,
GenericRepository<Bill>{

}
