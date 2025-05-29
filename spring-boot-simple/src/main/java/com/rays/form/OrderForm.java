package com.rays.form;

import java.util.Date;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.rays.common.BaseDTO;
import com.rays.common.BaseForm;
import com.rays.dto.OrderDTO;

public class OrderForm extends BaseForm {

	@NotNull(message = "quantity is required")
	private int quantity;

	@NotNull(message = "totalPrice is required")
	private int totalPrice;

	@NotNull(message = "orderDate is required")
	private Date orderDate;

	@NotEmpty(message = "status is required")
	private String status;

	public OrderForm() {

	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public BaseDTO getDto() {
		OrderDTO dto = (OrderDTO) initDTO(new OrderDTO());
		dto.setOrderDate(orderDate);
		dto.setQuantity(quantity);
		dto.setStatus(status);
		dto.setTotalPrice(totalPrice);
		return dto;
	}

}
