package com.bvb.digitaltouch.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import com.bvb.digitaltouch.Enum.ServiceType;
import com.bvb.digitaltouch.Enum.StatusType;
import com.bvb.digitaltouch.modules.User;

public class BillDto {
	private Integer id;
	private ServiceType serviceType;
	private StatusType status;
	private LocalDate issuedDate;
	private LocalDate dueDate;
	private BigDecimal amountDue;
	
	 public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	private User user;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public ServiceType getServiceType() {
		return serviceType;
	}
	public void setServiceType(ServiceType serviceType) {
		this.serviceType = serviceType;
	}
	public StatusType getStatus() {
		return status;
	}
	public void setStatus(StatusType status) {
		this.status = status;
	}
	public LocalDate getIssuedDate() {
		return issuedDate;
	}
	public void setIssuedDate(LocalDate issuedDate) {
		this.issuedDate = issuedDate;
	}
	public LocalDate getDueDate() {
		return dueDate;
	}
	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}
	public BigDecimal getAmountDue() {
		return amountDue;
	}
	public void setAmountDue(BigDecimal amountDue) {
		this.amountDue = amountDue;
	}
	
    

}
