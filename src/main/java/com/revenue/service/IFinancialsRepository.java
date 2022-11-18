package com.revenue.service;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revenue.model.Transaction;

@Repository
public interface IFinancialsRepository extends JpaRepository<Transaction, Integer> {
	
	

}
