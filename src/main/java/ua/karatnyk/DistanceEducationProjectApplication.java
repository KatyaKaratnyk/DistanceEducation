package ua.karatnyk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.security.crypto.password.PasswordEncoder;

import ua.karatnyk.entity.UserEntity;
import ua.karatnyk.enumerations.Role;
import ua.karatnyk.enumerations.School;
import ua.karatnyk.repository.UserRepository;


@SpringBootApplication
public class DistanceEducationProjectApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(DistanceEducationProjectApplication.class, args);
		addAdmin(context);
		addDirector(context);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(DistanceEducationProjectApplication.class);
	}
	
	static void addAdmin(ConfigurableApplicationContext context) {
		String adminLogin = "k.karatnyk";
		String adminPassword = "1111";
		
		UserRepository userRepository = context.getBean(UserRepository.class);
		UserEntity entity = userRepository.findUserByLoginAndActice(adminLogin);
		if(entity == null) {
			PasswordEncoder encoder = context.getBean(PasswordEncoder.class);
			
			entity = new UserEntity();
			entity.setLogin(adminLogin);
			entity.setPassword(encoder.encode(adminPassword));
			entity.setRole(Role.ROLE_ADMIN);
			
			userRepository.save(entity);
		}
	}
	
	static void addDirector(ConfigurableApplicationContext context) {
		String adminLogin = "p.karatnyk";
		String adminPassword = "1111";
		
		UserRepository userRepository = context.getBean(UserRepository.class);
		UserEntity entity = userRepository.findUserByLoginAndActice(adminLogin);
		if(entity == null) {
			PasswordEncoder encoder = context.getBean(PasswordEncoder.class);
			
			entity = new UserEntity();
			entity.setLogin(adminLogin);
			entity.setPassword(encoder.encode(adminPassword));
			entity.setRole(Role.ROLE_DIRECTOR);
			entity.setNumberSchool(School.NUMBER_84);
			
			userRepository.save(entity);
		}
	}
	
}
