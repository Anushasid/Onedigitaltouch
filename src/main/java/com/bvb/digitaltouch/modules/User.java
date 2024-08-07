package com.bvb.digitaltouch.modules;

import java.util.List;
import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "users_table")
public class User {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id",nullable=false)
	private Integer id;
	
	@Column(name="name",nullable=false)
	private String name;
	
	@Column(name="email",unique=true,nullable=false)
	private String email;
	
	@Column(name="phone_number",unique=true,nullable=false)
	private String phoneNumber;
	
	@Column(name="area",nullable=false)
	private String area;
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}

	@Column(name="city",nullable=false)
	private String city;
	
	@Column(name="pincode",nullable=false)
	private Integer pincode;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone_number() {
		return phoneNumber;
	}
	public void setPhone_number(String phone_number) {
		this.phoneNumber = phone_number;
	}
	
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public Integer getPincode() {
		return pincode;
	}
	public void setPincode(Integer pincode) {
		this.pincode = pincode;
	}
	
	@OneToMany(mappedBy = "id",cascade = CascadeType.PERSIST,orphanRemoval = true)
    private List<Bill> bill;
	
	@OneToMany(mappedBy ="id", cascade = CascadeType.PERSIST,orphanRemoval = true)
	private List<Payment> payment;
	
	@OneToMany(mappedBy ="id", cascade = CascadeType.PERSIST,orphanRemoval = true)
	private List<UserNotification>usernotification;

	
	@Override
	public String toString() {
		return "Users [user_id=" + id + ", name=" + name + ", email=" + email + ", phone_number=" + phoneNumber
				+ ", address=" + area + ", city=" + city + ", pincode=" + pincode + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(area, city, email, id, name, phoneNumber, pincode);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(area, other.area) && Objects.equals(city, other.city)
				&& Objects.equals(email, other.email) && Objects.equals(id, other.id)
				&& Objects.equals(name, other.name) && Objects.equals(phoneNumber, other.phoneNumber)
				&& Objects.equals(pincode, other.pincode);
	}
	
	

}
