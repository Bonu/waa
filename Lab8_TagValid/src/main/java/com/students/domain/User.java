package com.students.domain;

import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;

public class User {
	@Range(min = 100, max = 999) //age need between 100 and 999
	private int userId;
	
	@NotEmpty(message="{string.empty.emessage}")
	private String name = null;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}



}
