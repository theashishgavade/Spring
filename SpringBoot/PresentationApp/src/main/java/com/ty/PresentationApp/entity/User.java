package com.ty.PresentationApp.entity;

import com.ty.PresentationApp.enums.Role;
import com.ty.PresentationApp.enums.Status;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import java.util.List;

@Entity
@Data
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

//	@Size(min = 3, message = "Name cannot be empty")
	private String name;

	@Column(unique = true)
//	@Email(message = "Email should be valid")
	private String email;

	private Long phone;

	private String pass;

	@Enumerated(EnumType.STRING)
	private Status status;

	@Enumerated(EnumType.STRING)
	private Role role;

	private Double userTotalScore;

	// One User can have many Presentations
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Presentation> presentations;

//    // One User can have many Ratings
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Rating> ratings;
}
