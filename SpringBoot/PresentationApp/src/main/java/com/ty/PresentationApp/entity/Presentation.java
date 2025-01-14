package com.ty.PresentationApp.entity;

import java.util.List;

import com.ty.PresentationApp.enums.PresentationStatus;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
public class Presentation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Size(min = 2, message = "Course name cannot be empty")
	private String course;

	private PresentationStatus presentationStatus;

	private Double userTotalScore;

	// Many Presentations belong to one User
	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	private User user;

	// One Presentation can have one Rating
	// orphanRemoval = true ensures that if the Rating is removed from the Presentation,
	// the Rating entity is also deleted from the database automatically, preventing orphaned records.
//	@OneToMany(mappedBy = "presentation", cascade = CascadeType.ALL, orphanRemoval = true)
//	private Rating rating;
}
