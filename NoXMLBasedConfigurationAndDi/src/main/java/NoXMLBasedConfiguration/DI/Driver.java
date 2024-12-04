package NoXMLBasedConfiguration.DI;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;

public class Driver {
	public static void main(String[] args) {
		ConfigurableApplicationContext cApp = new AnnotationConfigApplicationContext(AppConfig.class);
		StudentDIConstructor studentDIConstructor = (StudentDIConstructor) cApp.getBean("studentDIConstructor");
		studentDIConstructor.Display();
		System.out.println("=======================\n");

		StudentDIVariable studentDIVariable = (StudentDIVariable) cApp.getBean("studentDIVariable");
		studentDIVariable.Display();
		System.out.println("=======================\n");

		StudentDISetter studentDISetter = (StudentDISetter) cApp.getBean("studentDISetter");
		System.out.println("DI for Setter");
		System.out.println(studentDISetter.getName());
		System.out.println(studentDISetter.getAge());

	}
}
