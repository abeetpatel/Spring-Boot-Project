package com.rays.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.rays.common.BaseDTO;

@Entity
@Table(name = "ST_BLOG")
public class BlogDTO extends BaseDTO {

	@Column(name = "TITLE", length = 50)
	private String title;

	@Column(name = "CONTENT", length = 50)
	private String content;

	@Column(name = "AUTHOR", length = 50)
	private String author;

	@Column(name = "TAGS", length = 50)
	private String tags;

	@Column(name = "CREATED_AT", length = 50)
	private String createdAt;

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
	public String getValue() {
		return title;
	}

}
