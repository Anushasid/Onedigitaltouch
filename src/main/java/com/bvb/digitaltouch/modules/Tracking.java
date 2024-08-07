package com.bvb.digitaltouch.modules;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name="tracking")
public class Tracking {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	@Column(name="id")
	private Integer id;
	
	@Column(name="status")
	private String status;
	
	
	@Column(name="time_stamp")
	private Date timeStamp;
	
	@Override
	public String toString() {
		return "Tracking [id=" + id + ", status=" + status + ", timeStamp=" + timeStamp + "]";
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public Date getTimeStamp() {
		return timeStamp;
	}


	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}


	
	
	
}
