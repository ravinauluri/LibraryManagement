package com.genpact.librarymanagement.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 703237279 on Jul, 2020
 */
@Entity
@Table(name = "LIBRARY")
@Data
public class Library implements Serializable {

    private static final long serialVersionUID = 7080075161005200218L;

    @Id
    @Column(name = "LibraryId")
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @Column(name = "LibraryName")
    private String name;

    @Column(name = "LibraryAddress")
    private String address;

    @Column(name = "ContactNumber")
    private Long contactNumber;

    @OneToMany(mappedBy = "library", fetch= FetchType.LAZY,orphanRemoval=true)
    private List<Book> book;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Long getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(Long contactNumber) {
		this.contactNumber = contactNumber;
	}

	public List<Book> getBook() {
		return book;
	}

	public void setBook(List<Book> book) {
		this.book = book;
	}
    
    

}
