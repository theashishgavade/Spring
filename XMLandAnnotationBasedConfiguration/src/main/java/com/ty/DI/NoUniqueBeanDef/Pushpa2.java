package com.ty.DI.NoUniqueBeanDef;

import org.springframework.stereotype.Component;

@Component
public class Pushpa2 implements Movie {

	public void Story() {
		System.out.println("Pushpa Movie Mat Dekho");
	}

}
