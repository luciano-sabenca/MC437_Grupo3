package MC437;


import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
@EnableAutoConfiguration

public class Main {
	public static void main(String args[]){
		SpringApplication.run(Main.class, args);
	}

}