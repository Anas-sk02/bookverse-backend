package com.bookverse.config;

import com.bookverse.entity.User;
import com.bookverse.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public DataInitializer(UserRepository userRepository,
                           PasswordEncoder passwordEncoder) {

        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) {

        if (userRepository.findByEmail("admin@bookverse.com").isEmpty()) {

            User admin = new User();

            admin.setName("Administrator");
            admin.setEmail("admin@bookverse.com");
            admin.setPassword(
                    passwordEncoder.encode("Admin@123")
            );
            admin.setRole("ROLE_ADMIN");

            userRepository.save(admin);

            System.out.println("Admin Created Successfully");
        }

    }
}
