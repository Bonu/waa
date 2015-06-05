package com.students.domain;

import java.util.Date;

import javax.validation.Valid;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;


public class Student {
	
	private int studentId;
	
	@NotEmpty(message="{field.empty.errormessage}")
	@Size(min=4, max=50, message="{name.size.errormessage}")
 	private String firstName = null;
	
	@NotEmpty(message="{field.empty.errormessage}")
	@Size(min=4, max=50, message="{name.size.errormessage}")
 	private  String lastName  = null;
	
	@NotEmpty(message="{field.empty.errormessage}")
	@Email
	private String email = null;

	@NotEmpty(message="{field.empty.errormessage}")
	@Size(min=4, max=6, message="{gender.errormessage}")
 	private String gender = null;
	
	@Past(message="{birthdate.errormessage}")
    private Date birthday;
	
	@Valid
	private Phone phone;

	
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public Phone getPhone() {
		return phone;
	}
	public void setPhone(Phone phone) {
		this.phone = phone;
	}	
	   	
	   

}
