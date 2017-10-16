package com.stackroute.RESTHackathon.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import io.swagger.annotations.ApiModelProperty;

//To declare fields for database table
@Entity
public class AppDomain {

	//Fields included
	@Id
	@Column(name="id")
	@ApiModelProperty(notes="Database Generated")
	private int id;
	@Column(name="email")
	private String email;
	@Column(name="name")
	private String name;
	
	
	//Getters and setters

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	//Constructors
	public AppDomain(int id, String email, String name) {
		super();
		this.id = id;
		this.email = email;
		this.name = name;
	}

	public AppDomain() {

	}

}
