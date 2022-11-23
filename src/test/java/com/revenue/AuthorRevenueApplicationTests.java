package com.revenue;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.sql.Date;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.web.client.RestTemplate;

import com.revenue.model.Transaction;

@SpringBootTest(classes = AuthorRevenueApplication.class, webEnvironment = WebEnvironment.RANDOM_PORT)
//@SpringBootTest
class AuthorRevenueApplicationTests {
	
	  
	  
	  //we will get the port refrence where application context is running
	  
	  @LocalServerPort private int port;
	  
	  private String baseUrl="http://localhost";
	  
	  
//	  @Autowired
//	  private static TestRestTemplate restTemplate;
	  
	  
	  @Autowired 
	  private static RestTemplate restTemplate;
	  
	  @Autowired 
	  private ITestH2Repository testRepo;
	  
	  @BeforeAll public static void init() { restTemplate=new RestTemplate(); }
	  
	  @BeforeEach public void setUp() {
	  baseUrl=baseUrl.concat(":").concat(port+"");
	  
	  }
	  
	  
	  @Test public void testTransaction() { Transaction transaction = new
	  Transaction(24,"kevin",100.0,null,1,true,3,2,4,"cartoon");
	  
	  Transaction response = restTemplate.postForObject(baseUrl+"/transactionss",
	  transaction, Transaction.class);
	  
	  assertEquals("catoon", response.getBookTitle()); assertEquals(1,
	  testRepo.findAll().size()); }
	  
	  
	  
	  
	 
	  
	 
	@Test
	void contextLoads() {
	}	
}
