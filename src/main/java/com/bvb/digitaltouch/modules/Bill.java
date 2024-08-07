package com.bvb.digitaltouch.modules;

import java.math.BigDecimal;

import java.time.LocalDate;
import java.util.Objects;
import com.bvb.digitaltouch.Enum.ServiceType;
import com.bvb.digitaltouch.Enum.StatusType;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

@Entity
@Table(name = "bills")
public class Bill {

    @Id
    @GeneratedValue
    @Column(name="id")
    private Integer id;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "service_type", length = 50,nullable=false)
    private ServiceType serviceType;
    
    @Column(name="amount_due", precision = 6, scale = 2)
    private BigDecimal amountDue;
    
    @Column(name="due_date")
    private LocalDate dueDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", length = 50,nullable=false)
    private StatusType status;

    @Column(name="issued_date")
    private LocalDate issuedDate;
     
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    private User user;

    @OneToOne(mappedBy = "bill", cascade = CascadeType.ALL)
    private Payment payment;
    
    
   
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

	public BigDecimal getAmountDue() {
		return amountDue;
	}

	public void setAmountDue(BigDecimal amountDue) {
		this.amountDue = amountDue;
	}

	public LocalDate getDueDate() {
		return dueDate;
	}

	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Bill [id=" + id + ", serviceType=" + serviceType + ", amountDue=" + amountDue + ", dueDate=" + dueDate
				+ ", status=" + status + ", issuedDate=" + issuedDate + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(amountDue, dueDate, id, issuedDate, serviceType, status);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bill other = (Bill) obj;
		return Objects.equals(amountDue, other.amountDue) && Objects.equals(dueDate, other.dueDate)
				&& Objects.equals(id, other.id) && Objects.equals(issuedDate, other.issuedDate)
				&& serviceType == other.serviceType && status == other.status;
	}
	
	
}
