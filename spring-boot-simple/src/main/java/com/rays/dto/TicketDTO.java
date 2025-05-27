package com.rays.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.rays.common.BaseDTO;

@Entity
@Table(name = "ST_TICKET")
public class TicketDTO extends BaseDTO {

	@Column(name = "SUBJECT", length = 50)
	private String subject;

	@Column(name = "DESCRIPTION", length = 50)
	private String description;

	@Column(name = "CREATED_BY", length = 50)
	private String createdBy;

	@Column(name = "ASSIGNED_TO", length = 50)
	private String assignedTo;

	@Column(name = "PRIORITY", length = 50)
	private String priority;

	@Column(name = "STATUS", length = 50)
	private String status;

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getAssignedTo() {
		return assignedTo;
	}

	public void setAssignedTo(String assignedTo) {
		this.assignedTo = assignedTo;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String getValue() {
		return null;
	}

}
