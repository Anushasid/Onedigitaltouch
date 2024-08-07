package com.bvb.digitaltouch.modules;

import java.util.Objects;


import com.bvb.digitaltouch.Enum.ServiceType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
@Entity
@Table(name="feedback")
public class Feedback {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	@ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    private User user;
	
	 public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Enumerated(EnumType.STRING)
	 @Column(name = "service_type", length = 50,nullable=false)
	    private ServiceType serviceType;
	
	public ServiceType getServiceType() {
		return serviceType;
	}

	public void setServiceType(ServiceType serviceType) {
		this.serviceType = serviceType;
	}

	@Column(name="feedback_text",length=200)
	private String feedbackText;
	
	@Column(name="rating")
	private Integer rating;
	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	
	public String getFeedbackText() {
		return feedbackText;
	}

	public void setFeedbackText(String feedbackText) {
		this.feedbackText = feedbackText;
	}

	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

	@Override
	public String toString() {
		return "Feedback [id=" + id + ", serviceType=" + serviceType + ", feedbackText="
				+ feedbackText + ", rating=" + rating + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(feedbackText, id, rating, serviceType);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Feedback other = (Feedback) obj;
		return Objects.equals(feedbackText, other.feedbackText) && Objects.equals(id, other.id)
				&& Objects.equals(rating, other.rating) && serviceType == other.serviceType;
	}
	
	
	

	
}
