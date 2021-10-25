package com.spandiar.jdbcjpa.jdbcjpah2demo.entity;

import java.util.Date;

import javax.persistence.Column;

public class Author {
	
	private int id;
	private String name;
	private Date dob;
	private String gender;
	@Column(name="CREATED_DT")
	private Date createdDate;
	@Column(name="MODIFIED_DT")
	private Date modifiedDate;
	
	
	public Author() {

	}
	

	public Author(int id, String name, Date dob, String gender) {
		super();
		this.id = id;
		this.name = name;
		this.dob = dob;
		this.gender = gender;
	}




	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Date getDob() {
		return dob;
	}


	public void setDob(Date dob) {
		this.dob = dob;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public Date getCreatedDate() {
		return createdDate;
	}


	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}


	public Date getModifiedDate() {
		return modifiedDate;
	}


	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}


	@Override
	public String toString() {
		return "\n Person [id=" + id + ", name=" + name + ", dob=" + dob + ", gender=" + gender + ", createdDate="
				+ createdDate + ", modifiedDate=" + modifiedDate + "]";
	}
	
	
}
