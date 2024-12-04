package NoXMLBasedConfiguration.DI;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class StudentDISetter {
	private String name;
	private int age;

	public String getName() {
		return name;
	}

	@Value(value = "Ashish")
	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	@Value(value = "24")
	public void setAge(int age) {
		this.age = age;
	}

}
