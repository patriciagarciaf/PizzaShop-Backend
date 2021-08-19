package com.example.demo.Domain.UserDomain;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Id;

import org.hibernate.annotations.Type;

public class UserStatus {
    
    
    @Id
    @Type (type = "uuid-char")
    public UUID id;

    //TODO: user-id

	@Column (nullable = false)
	public RegisterStatus registerStatus;

    @Column (nullable = false)
	public RegisterProvider registerProvider;
}
