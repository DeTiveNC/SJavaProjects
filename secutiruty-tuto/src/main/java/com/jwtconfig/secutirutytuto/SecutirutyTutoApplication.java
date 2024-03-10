package com.jwtconfig.secutirutytuto;

import com.jwtconfig.secutirutytuto.entity.Role;
import com.jwtconfig.secutirutytuto.entity.User;
import com.jwtconfig.secutirutytuto.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class SecutirutyTutoApplication implements CommandLineRunner {
	@Autowired
	private UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(SecutirutyTutoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		User adminAccount = userRepository.findByRole(Role.ADMIN);
		if (adminAccount == null) {
			User admin = new User();
			admin.setEmail("admin@admin.com");
			admin.setFirstName("admin");
			admin.setLastName("admin");
			admin.setRole(Role.ADMIN);
			admin.setPassword(new BCryptPasswordEncoder().encode("admin"));
			userRepository.save(admin);
		}
	}
}
