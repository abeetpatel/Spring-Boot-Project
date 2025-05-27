package com.rays.form;

import java.util.Date;

import javax.validation.constraints.NotEmpty;

import com.rays.common.BaseDTO;
import com.rays.common.BaseForm;
import com.rays.dto.EmployeeDTO;

public class EmployeeForm extends BaseForm {

	@NotEmpty(message = "name is required")
	private String name;

	@NotEmpty(message = "email is required")
	private String email;

	@NotEmpty(message = "department is required")
	private String department;

	@NotEmpty(message = "joiningDate is required")
	private Date joiningDate;

	@NotEmpty(message = "salary is required")
	private int salary;

	public EmployeeForm() {

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

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public Date getJoiningDate() {
		return joiningDate;
	}

	public void setJoiningDate(Date joiningDate) {
		this.joiningDate = joiningDate;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	@Override
	public BaseDTO getDto() {
		EmployeeDTO dto = (EmployeeDTO) initDTO(new EmployeeDTO());
		dto.setName(name);
		dto.setEmail(email);
		dto.setDepartment(department);
		dto.setJoiningDate(joiningDate);
		dto.setSalary(salary);
		return dto;
	}
}
