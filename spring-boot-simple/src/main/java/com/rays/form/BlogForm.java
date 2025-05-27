package com.rays.form;

import javax.validation.constraints.NotEmpty;

import com.rays.common.BaseDTO;
import com.rays.common.BaseForm;
import com.rays.dto.BlogDTO;

public class BlogForm extends BaseForm {

	@NotEmpty(message = "title is required")
	private String title;

	@NotEmpty(message = "content is required")
	private String content;

	@NotEmpty(message = "author is required")
	private String author;

	@NotEmpty(message = "tags is required")
	private String tags;

	@NotEmpty(message = "createdAt is required")
	private String createdAt;

	public BlogForm() {

	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	@Override
	public BaseDTO getDto() {
		BlogDTO dto = (BlogDTO) initDTO(new BlogDTO());
		dto.setTitle(title);
		dto.setContent(content);
		dto.setAuthor(author);
		dto.setTags(tags);
		dto.setCreatedAt(createdAt);
		return dto;
	}
}
