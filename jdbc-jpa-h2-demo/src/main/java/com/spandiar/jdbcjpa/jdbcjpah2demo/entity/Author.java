package com.spandiar.jdbcjpa.jdbcjpah2demo.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name="author")
@NamedQuery(name = "find_all_authors", query = "select a from Author a")
public class Author {
	
	@Id
	@GeneratedValue
	private int id;
	private String name;
	private LocalDate dob;
	private String gender;
	@Column(name="createdDate", updatable = false)
	@CreationTimestamp
	private LocalDateTime createdDate;
	@Column(name="modifiedDate")
	@UpdateTimestamp
	private LocalDateTime modifiedDate;
	
	
	public Author() {

	}
	

	public Author(String name, LocalDate dob, String gender) {
		super();
		this.name = name;
		this.dob = dob;
		this.gender = gender;
	}
	
	public Author(int id, String name, LocalDate dob, String gender) {
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


	public LocalDate getDob() {
		return dob;
	}


	public void setDob(LocalDate dob) {
		this.dob = dob;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public LocalDateTime getCreatedDate() {
		return createdDate;
	}


	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}


	public LocalDateTime getModifiedDate() {
		return modifiedDate;
	}


	public void setModifiedDate(LocalDateTime modifiedDate) {
		this.modifiedDate = modifiedDate;
	}


	@Override
	public String toString() {
		return "\n Person [id=" + id + ", name=" + name + ", dob=" + dob + ", gender=" + gender + ", createdDate="
				+ createdDate + ", modifiedDate=" + modifiedDate + "]";
	}
	
	
}
