package NoXMLBasedConfiguration.DI;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class StudentDIConstructor {

	String name;

	int age;

	public StudentDIConstructor(@Value(value = "Ashish") String name, @Value(value = "24") int age) {
		this.name = name;
		this.age = age;
	}

	public void Display() {
		System.out.println("DI for Constructor");
		System.out.println("Name : " + name);
		System.out.println("Age : " + age);
	}
}
