package com.rays.form;

import java.util.Date;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

public class UserRegistrationForm {

	@NotEmpty(message = "First Name is required")
	private String firstName;

	@NotEmpty(message = "Last Name is required")
	private String lastName;

	@NotEmpty(message = "Login Id is required")
	private String loginId;

	@NotEmpty(message = "Password is required")
	private String password;

	@NotNull(message = "Date of birth is required")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dob;

	public UserRegistrationForm() {
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

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}
}