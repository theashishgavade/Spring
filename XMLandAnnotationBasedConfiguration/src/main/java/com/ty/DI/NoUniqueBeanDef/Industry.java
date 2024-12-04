package com.ty.DI.NoUniqueBeanDef;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Industry {
// 	Using Variable / Field Injection
// 	@Autowired
//	@Qualifier(value = "KGF")
	Movie movie;

// 	Using Setter Injection
// 	@Autowired
//	@Qualifier(value = "KGF")
	public void setMovie(Movie movie) {
		this.movie = movie;
	}

// 	Using Constructor Injection
	@Autowired
	public Industry(@Qualifier(value = "KGF") Movie movie) {
		this.movie = movie;
	}

	public void budget() {
		System.out.println("Budget invested on movie industry");
		movie.Story();
	}

}
