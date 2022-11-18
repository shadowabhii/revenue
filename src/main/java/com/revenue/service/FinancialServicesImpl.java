package com.revenue.service;


import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.revenue.model.Transaction;


@Service
public class FinancialServicesImpl implements IFinancialServices {

	@Autowired
	private IFinancialsRepository financialsRepository; 
	
	@Autowired
	private FinancialCustomRepository financialCustomRepository;
	
	@Override
	public Integer bookPurchased(Transaction transaction) {
		Transaction purchasedBook = financialsRepository.save(transaction);
		return purchasedBook.gettId();
	}

	@Override
	public Double authorRevenue(Integer authorId) {
		
		List<Transaction> records=	financialsRepository.findAll().stream().filter(e-> (e.getaId()==authorId)).
				collect(Collectors.toList());
		
		double totalPrice=0.0;
		for(int i=0;i<records.size();i++)
		{
			totalPrice=totalPrice+records.get(i).getPrice();
		}
			
			return totalPrice;
		}

	
		@Override
	public Double authorRevenueBetweenDates(Date startDate, Date endDate, Integer authorId) {

		List<Transaction> records1 = financialCustomRepository.findBydateBetween(startDate, endDate);
		
	
		

		double totalPrice=0.0;
		for(int i=0;i<records1.size();i++)
		{
			totalPrice=totalPrice+records1.get(i).getPrice();
		}
			
			System.out.println(totalPrice);

		return totalPrice;
	}

		@Override
		public List<Transaction> getAuthorHistory(Integer authorId) {
			
			List<Transaction> records=	financialsRepository.findAll().stream().filter(e-> (e.getaId()==authorId)).
					collect(Collectors.toList());
			
			return records;
		}
	 

		
		

}
