package com.bvb.digitaltouch.modules;

import java.math.BigDecimal;

import java.time.LocalDateTime;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="payments")
public class Payment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	@Column(name="id",nullable=false)
	private Integer id;
	
	@Column(name="payment_date")
	private LocalDateTime paymentDate;
	
	@Column(name="amount_paid")
	private BigDecimal amountPaid;
	
	@Column(name="payment_method",nullable=false)
	private String paymentMethod;
	
	
	 @OneToOne
	    @JoinColumn(name = "bill_id", nullable = false)
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
	@Override
	public String toString() {
		return "Payments [id=" + id + ", paymentDate=" + paymentDate + ", amountPaid=" + amountPaid + ", paymentMethod="
				+ paymentMethod + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(amountPaid, id, paymentDate, paymentMethod);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Payment other = (Payment) obj;
		return Objects.equals(amountPaid, other.amountPaid) && Objects.equals(id, other.id)
				&& Objects.equals(paymentDate, other.paymentDate) && Objects.equals(paymentMethod, other.paymentMethod);
	}
	
	

	
	
}
