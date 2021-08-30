package com.example.demo.Domain.UserDomain;

import javax.persistence.*;
import javax.validation.constraints.*;
import com.example.demo.core.EntityBase;
import lombok.*;

@Entity
public @NoArgsConstructor @Getter @Setter class User extends EntityBase {
	@NotBlank(message = "Name error.")
	@Column(nullable = false)
	private String name;

	@NotBlank(message = "Surname error.")
	@Column(nullable = false)
	private String surname;

	@Email(message = "That's not a valid email.")
	@Column(unique = true)
	private String email;

	@NotNull(message = "Password can't be null.")
	@Column
	private String password;

	@Column
	@Enumerated(EnumType.STRING)
	@NotNull(message = "Role can't be null.")
	private Roles role;

}
