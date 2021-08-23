package com.example.demo.Domain.UserDomain;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import javax.validation.constraints.*;

import com.example.demo.core.EntityBase;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public @NoArgsConstructor @Getter @Setter class User extends EntityBase{
 

	@NotBlank
	@Column (nullable = false)
	private String name;

	@NotBlank
	@Column (nullable = false)
	private String surname;

	@NotNull
	@Email
	@Column(unique = true)
	private String email;

	@Column 
	private String password;	// public String password; using bcrypt to save it


	@Column //(nullable = false)
	@Enumerated(EnumType.STRING)
	private Roles role;

}
