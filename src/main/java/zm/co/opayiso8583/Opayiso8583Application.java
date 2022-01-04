package zm.co.opayiso8583;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class Opayiso8583Application {

	
	public static void main(String[] args) {
		SpringApplication.run(Opayiso8583Application.class, args);
	}

}
