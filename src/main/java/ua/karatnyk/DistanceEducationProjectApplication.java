package ua.karatnyk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
public class DistanceEducationProjectApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(DistanceEducationProjectApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(DistanceEducationProjectApplication.class);
	}
	
	
}
