package com.bvb.digitaltouch.dto;

import java.math.BigDecimal;

import java.time.LocalDateTime;

import com.bvb.digitaltouch.modules.Bill;


public class PaymentDto {
	
	
	private Integer id;
	private LocalDateTime paymentDate;
	private BigDecimal amountPaid;
	private String paymentMethod;
	private Bill bill;
	
	public Bill getBill() {
		return bill;
	}
	public void setBill(Bill bill) {
		this.bill = bill;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public LocalDateTime getPaymentDate() {
		return paymentDate;
	}
	public void setPaymentDate(LocalDateTime paymentDate) {
		this.paymentDate = paymentDate;
	}
	public BigDecimal getAmountPaid() {
		return amountPaid;
	}
	public void setAmountPaid(BigDecimal amountPaid) {
		this.amountPaid = amountPaid;
	}
	public String getPaymentMethod() {
		return paymentMethod;
	}
	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	
	

}
