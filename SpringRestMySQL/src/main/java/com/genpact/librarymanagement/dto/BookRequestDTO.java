package com.genpact.librarymanagement.dto;

import lombok.Data;

/**
 * @author 703237279 on Jul, 2020
 */
@Data
public class BookRequestDTO {
    private String title;
    private String publisher;
    private String price;
    private String author;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
    
    
}
