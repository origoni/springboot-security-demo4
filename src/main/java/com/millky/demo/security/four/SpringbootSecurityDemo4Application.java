package com.millky.demo.security.four;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.PostConstruct;

@Slf4j
@SpringBootApplication
public class SpringbootSecurityDemo4Application {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    public static void main(String[] args) {
        SpringApplication.run(SpringbootSecurityDemo4Application.class, args);
    }

    @PostConstruct
    public void init() {
        User user = new User();
        user.setUsername("admin");
        user.setEmail("admin@millky.com");
        user.setPassword(passwordEncoder.encode("adminPassword"));
        user.setEnabled(true);
        user.setRole(Role.ADMIN);
        userRepository.save(user);
    }
}
