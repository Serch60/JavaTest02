package practicascloud.baselineservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.Scanner;


@SpringBootApplication
public class BaselineServiceApplication {


	public static void main(String[] args) {
		SpringApplication.run(BaselineServiceApplication.class, args);

		BaselineServiceApplication bsApp = new BaselineServiceApplication();
	}
}
