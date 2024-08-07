package com.bvb.digitaltouch.modules;

import java.time.LocalDateTime;

import java.util.Objects;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
@Entity
@Table(name="user_notification")
public class UserNotification {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	@Column(name="title")
	private String title;
	
	@Column(name="message",length=500)
 	private String message;
	
	@Column(name="is_read")
 	private Boolean isRead;
	
	public Boolean getIsRead() {
		return isRead;
	}
	public void setIsRead(Boolean isRead) {
		this.isRead = isRead;
	}
	@Column(name="created_at")
 	private LocalDateTime createdAt;
	
	
	 @ManyToOne
	    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
	    private User user;
	 
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
	
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		public String getMessage() {
			return message;
		}
		public void setMessage(String message) {
			this.message = message;
		}
		@Override
		public String toString() {
			return "UserNotification [id=" + id + ", title=" + title + ", message=" + message + ", isRead=" + isRead
					+ ", createdAt=" + createdAt + "]";
		}
		@Override
		public int hashCode() {
			return Objects.hash(createdAt, id, isRead, message, title);
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			UserNotification other = (UserNotification) obj;
			return Objects.equals(createdAt, other.createdAt) && Objects.equals(id, other.id)
					&& Objects.equals(isRead, other.isRead) && Objects.equals(message, other.message)
					&& Objects.equals(title, other.title);
		}
		
		
		
		
		
}
