package com.revenue.service;

import java.sql.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.revenue.model.Transaction;

public interface FinancialCustomRepository extends CrudRepository<Transaction,Integer> {
	
	
	//method to return data between dates
	List<Transaction> findBydateBetween(Date startDate, Date endDate);

	//List<Transaction> findBydateBetween(java.util.Date startDate, java.util.Date endDate);

}
