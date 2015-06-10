package com.packt.webstore.domain;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Employee implements Serializable{
 
	/**
	 * 
	 */
	private static final long serialVersionUID = 8280781447546929099L;

	@GeneratedValue(strategy=GenerationType.AUTO)
	@Id
	private int id=0;
	
	@Column(name = "FIRST_NAME")
	private String firstName;
	
	@Column(name = "LAST_NAME")
	private String lastName;
 
	@Column(name = "AGE")
	private int age;
	
	@Column(name = "TITLE")
	private String title;
 
	@Column(name = "EMP_NUMBER")
	private int employeeNumber;
	
	// ONE TO ONE - the fetch type is Eager for one-to-one
	@OneToOne(cascade = CascadeType.ALL)
	private Address address;
	
 	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
 	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getEmployeeNumber() {
		return employeeNumber;
	}
	public void setEmployeeNumber(int employeeNumber) {
		this.employeeNumber = employeeNumber;
	}
 
}
