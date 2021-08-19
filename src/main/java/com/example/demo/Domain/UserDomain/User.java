package com.example.demo.Domain.UserDomain;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import javax.validation.constraints.*;

import com.example.demo.Core.EntityBase;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import javax.persistence.Column;


public class User extends EntityBase{
 
    


	@NotBlank
	@Column (nullable = false)
	private String name;

	@NotBlank
	@Column (nullable = false)
	private String surname;

	@Email
	@Column (nullable = false, unique = true)
	private String email;

	@Min(8)
	@Max(16)
	@Column (nullable = false)
	private String password;	// public String password; using bcrypt to save it


	@Column //(nullable = false)
	@Enumerated(EnumType.STRING)
	private Roles role;

}
