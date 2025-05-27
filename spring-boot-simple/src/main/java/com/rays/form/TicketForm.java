package com.rays.form;

import javax.validation.constraints.NotEmpty;

import com.rays.common.BaseDTO;
import com.rays.common.BaseForm;
import com.rays.dto.TicketDTO;

public class TicketForm extends BaseForm {

	@NotEmpty(message = "subject is required")
	private String subject;

	@NotEmpty(message = "description is required")
	private String description;

	@NotEmpty(message = "createdBy is required")
	private String createdBy;

	@NotEmpty(message = "assignedTo is required")
	private String assignedTo;

	@NotEmpty(message = "priority is required")
	private String priority;

	@NotEmpty(message = "status is required")
	private String status;

	public TicketForm() {
	}

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
	public BaseDTO getDto() {
		TicketDTO dto = (TicketDTO) initDTO(new TicketDTO());
		dto.setSubject(subject);
		dto.setDescription(description);
		dto.setCreatedBy(createdBy);
		dto.setAssignedTo(assignedTo);
		dto.setPriority(priority);
		dto.setStatus(status);
		return dto;
	}
}
