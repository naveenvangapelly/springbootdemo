package com.example.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "student")
public class StudentEntity implements Serializable {

	private static final long serialVersionUID = 1641539836392554069L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "firstname")
	private String firstName;
	
	@Column(name = "lastname")
	private String lastName;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "phone")
	private String phone;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstName;
	}

	public void setFirstname(String firstName) {
		this.firstName = firstName;
	}

	public String getLastname() {
		return lastName;
	}

	public void setLastname(String lastName) {
		this.lastName = lastName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

}
