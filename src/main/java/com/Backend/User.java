package com.Backend;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.Type;

import java.util.UUID;

import javax.persistence.Column;

@Entity 
public class User{

    @Id
    @Type (type = "uuid-char")
    public UUID id;
	@Column
	public String name;
	@Column
	public String email;
	// @Column
	// public String password; using bcrypt to save it

	//TODO: ACL fields
	
//TODO: comment the setters after testing

	public void setName(String name) {
		this.name = name;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
