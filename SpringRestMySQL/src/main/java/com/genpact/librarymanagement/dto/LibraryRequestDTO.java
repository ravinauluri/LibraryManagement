package com.genpact.librarymanagement.dto;

import lombok.Data;

/**
 * @author 703237279 on Jul, 2020
 */
@Data
public class LibraryRequestDTO {

    private String name;

    private String address;

    private Long contactNumber;

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
    
    
}
