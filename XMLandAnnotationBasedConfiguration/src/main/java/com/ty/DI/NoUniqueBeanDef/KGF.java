package com.ty.DI.NoUniqueBeanDef;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
//@Primary  //Example of Primary
public class KGF implements Movie {

	public void Story() {
		System.out.println("KGF Movie Mat Dekho");
	}

}
