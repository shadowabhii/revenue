package com.revenue.service;



import java.sql.Date;
import java.util.List;

import com.revenue.model.Transaction;

public interface IFinancialServices {

	Integer bookPurchased(Transaction transaction);
	Double authorRevenue(Integer authorId);
	//Double authorRevenueBetweenDates(Date endDate,Date startDate,Integer authorId);
	Double authorRevenueBetweenDates(Date startDate,Date endDate, Integer authorId);
	List<Transaction> getAuthorHistory(Integer authorId);
	
	
}
