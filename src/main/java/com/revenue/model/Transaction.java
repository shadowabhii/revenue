package com.revenue.model;



import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Transaction {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)	
	private Integer tId;
	
	private String readerName;
	private Double price;
	private Date date;
	private Integer quantity;
	private Boolean authorNotified;
	private Integer readerId;
	private Integer bookId;
	private Integer aId;
	
	public Integer gettId() {
		return tId;
	}
	public void settId(Integer tId) {
		this.tId = tId;
	}
	
	
	public Integer getaId() {
		return aId;
	}
	public void setaId(Integer aId) {
		this.aId = aId;
	}
	
	public String getReaderName() {
		return readerName;
	}
	public void setReaderName(String readerName) {
		this.readerName = readerName;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Boolean getAuthorNotified() {
		return authorNotified;
	}
	public void setAuthorNotified(Boolean authorNotified) {
		this.authorNotified = authorNotified;
	}
	public Integer getReaderId() {
		return readerId;
	}
	public void setReaderId(Integer readerId) {
		this.readerId = readerId;
	}
	public Integer getBookId() {
		return bookId;
	}
	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}
	public Transaction(Integer tId, Integer aId, String readerName, Double price, Date date, Integer quantity,
			Boolean authorNotified, Integer readerId, Integer bookId) {
		super();
		this.tId = tId;
		this.aId = aId;
		this.readerName = readerName;
		this.price = price;
		this.date = date;
		this.quantity = quantity;
		this.authorNotified = authorNotified;
		this.readerId = readerId;
		this.bookId = bookId;
	}
	public Transaction() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Transaction [tId=" + tId + ", readerName=" + readerName + ", price=" + price + ", date=" + date
				+ ", quantity=" + quantity + ", authorNotified=" + authorNotified + ", readerId=" + readerId
				+ ", bookId=" + bookId + ", aId=" + aId + "]";
	}

	
	
	
	
	

}
