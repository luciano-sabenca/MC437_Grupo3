package mc437;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@ComponentScan
@EnableAutoConfiguration
public class Main {
	public static void main(String args[]) {
		
		SpringApplication.run(Main.class, args);
	}

}
