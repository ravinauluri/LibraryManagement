package com.genpact.librarymanagement.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import lombok.Data;


/**
 * @author 703237279 on Jul, 2020
 */

@Entity
@Table(name = "BOOKS")
@Data
public class Book implements Serializable {

    private static final long serialVersionUID = 7080075161005200218L;

    @Id
    @Column(name = "Book_Id")
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    
    @Column(name = "Title")
    private String title;

    @Column(name = "Publisher")
    private String publisher;

    @Column(name = "Price")
    private String price;

    @Column(name = "Author")
    private String author;

    @ManyToOne
    @JoinColumn(name = "LibraryId")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Library library;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


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

	public Library getLibrary() {
		return library;
	}

	public void setLibrary(Library library) {
		this.library = library;
	}

}
