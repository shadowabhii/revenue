package com.revenue;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.sql.Date;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.netflix.discovery.converters.Auto;
import com.revenue.model.Transaction;
import com.revenue.service.FinancialCustomRepository;
import com.revenue.service.IFinancialsRepository;



@SpringBootTest(classes = AuthorRevenueApplication.class, webEnvironment = WebEnvironment.RANDOM_PORT)
//@SpringBootTest
@AutoConfigureMockMvc
class AuthorRevenueApplicationTests {
	
	  
	  
	  //we will get the port refrence where application context is running
	  
	  @LocalServerPort private int port;
	  
	  private String baseUrl="http://localhost";
	  
	  @Autowired
	  private MockMvc mockMvc;
	  
	  @Autowired
	 private FinancialCustomRepository financialCustomRepository;
	  
	  @Autowired
	 private  IFinancialsRepository financialRepo;
	  
	  @Autowired
	  private ObjectMapper objectMapper;
	  
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
	  
	  
//	  @Test public void testTransaction() { 
//		  Transaction transaction = new	  Transaction(24,"kevin",100.0,null,1,true,3,2,4,"cartoon");
//	  
//	  Transaction response = restTemplate.postForObject(baseUrl+"/transactionss", transaction, Transaction.class);
//	  
//	  assertEquals("catoon", response.getBookTitle()); 
//	  assertEquals(1, testRepo.findAll().size()); 
//	  }
	  
	  @Test
	  public void testTransaction() throws Exception
	  {
		  Transaction transaction = new	  Transaction(24,"kevin",100.0,null,1,true,3,2,4,"cartoon");
		  
		  ResultActions response = mockMvc.perform(post("/transactionss")
				  .contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(transaction)));
				  
			response.andDo(print()).
			andExpect(status().isCreated())
			.andExpect(jsonPath("$.readerName", is(transaction.getReaderName())));
				  
	  }
	  
	  @Test public void testRevenue() { 
		  Double price=0.0;
		  
	 
	  
	  Double response = restTemplate.getForObject(baseUrl+"revenue/1", Double.class);
	  
	  assertEquals(136, response); 
	 // assertEquals(1, testRepo.findAll().size()); 
	  }
	  
	  
	  @Test public void testRevenueBetweenDates() { 
		  Double price=0.0;
		  
	 Date startDate = null;
	 Date endDate = null;
	 int authorId=1;
	  
	  Double response = restTemplate.getForObject(baseUrl+"rev/"+ startDate +"/"+endDate+authorId, Double.class);
	  
	  assertEquals(136, response); 
	 // assertEquals(1, testRepo.findAll().size()); 
	  }
	  
	  
	  
	 
	  
	 
	@Test
	void contextLoads() {
	}	
}
