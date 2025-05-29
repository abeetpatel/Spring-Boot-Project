package com.rays.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.rays.common.BaseDTO;
import com.rays.common.BaseForm;
import com.rays.dto.ProductDTO;

public class ProductForm extends BaseForm {

	@NotEmpty(message = "name is required")
	private String name;

	@NotEmpty(message = "description is required")
	private String description;

	@NotNull(message = "price is required")
	private int price;

	@NotNull(message = "quantity is required")
	private int quantity;

	@NotEmpty(message = "category is required")
	private String category;

	@NotEmpty(message = "status is required")
	private String status;

	public ProductForm() {

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public BaseDTO getDto() {
		ProductDTO dto = (ProductDTO) initDTO(new ProductDTO());
		dto.setName(name);
		dto.setDescription(description);
		dto.setPrice(price);
		dto.setQuantity(quantity);
		dto.setCategory(category);
		dto.setStatus(status);
		return dto;
	}
}
