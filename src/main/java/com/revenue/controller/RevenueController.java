package com.revenue.controller;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.revenue.model.Transaction;
import com.revenue.service.FinancialServicesImpl;
import com.revenue.service.IFinancialServices;
import com.revenue.service.IFinancialsRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class RevenueController {

	@Autowired
	RestTemplate restTemplate;

	@Autowired
	private IFinancialServices financialServices;

	@Autowired
	private IFinancialsRepository financialsRepository;

	@GetMapping("/revenue/{authorId}")
	public Double getTotalRevenue(@PathVariable("authorId") Integer authorId) {

		System.out.println("inside reader");

		Double totalPrice = financialServices.authorRevenue(authorId);

		System.out.println(totalPrice);
		return totalPrice;
	}

	@PostMapping("/transactionss")
	public Integer bookPurchasedTransaction(@RequestBody Transaction transaction) {

		Integer id = financialServices.bookPurchased(transaction);
		return id;
	}

	@GetMapping("/hello")
	public String hello() {

		return "Hello";
	}

	/*
	 * @GetMapping("/hi") public void hi() throws Exception { SimpleDateFormat fmt =
	 * new SimpleDateFormat("yyyy/MM/dd"); Date startdate = (Date)
	 * fmt.parse("2013/05/06"); Date enddate = (Date) fmt.parse("2013/05/06");
	 * 
	 * financialServices.authorRevenueBetweenDates(startdate, enddate, 1); }
	 */
	
	@GetMapping("/rev/{startDate}/{endDate}/{authorId}")
	public Double getLaptopsByPrice (@PathVariable Date startDate,
			@PathVariable Date endDate , @PathVariable Integer authorId) {
		
		Double revenueBetweenDates = financialServices.authorRevenueBetweenDates(startDate, endDate, authorId);
		
		return revenueBetweenDates;
		
	}
	
	@GetMapping("authorHistory/{aId}")
	public List<Transaction> getAuthorHistory(@PathVariable Integer aId)
	{
		
		List<Transaction> authorHistory = financialServices.getAuthorHistory(aId);
		return authorHistory;
		
	}

	
	  
	  
	 

}
