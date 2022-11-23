
  package com.revenue;
  
  import org.springframework.data.jpa.repository.JpaRepository;
  
  import com.revenue.model.Transaction;
  
  public interface ITestH2Repository extends JpaRepository<Transaction,
  Integer> {
  
  }
 