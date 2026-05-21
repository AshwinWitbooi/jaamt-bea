package za.co.ashtech.jaatm.bea;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableAspectJAutoProxy
@SpringBootApplication
public class JaatmBeaApplication {

	public static void main(String[] args) {
		SpringApplication.run(JaatmBeaApplication.class, args);
	}

}
