package com.millky.demo.security.four;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserService {

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    UserRepository userRepository;

    public User join(User user) {

        if (userRepository.findByUsername(user.getUsername()) != null) {
            return null;
        }

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setEnabled(true);
        user.setRole(Role.USER);

        User newUser = userRepository.save(user);
        log.debug("newUser={}", newUser);

        return newUser;
    }

    @PreAuthorize("isAuthenticated() and ((#user.getUsername() == principal.getUsername()) or hasRole('ROLE_ADMIN'))")
    public User update(User user) {

        User foundUser = userRepository.findByUsername(user.getUsername());
        foundUser.setEmail(user.getEmail());

        User updatedUser = userRepository.save(foundUser);
        log.debug("updatedUser={}", updatedUser);

        return updatedUser;
    }

    @PreAuthorize("isAuthenticated() and ((#name == principal.getUsername()) or hasRole('ROLE_ADMIN'))")
    public User updateEmail(String name, String email) {

        User foundUser = userRepository.findByUsername(name);
        foundUser.setEmail(email);

        User updatedUser = userRepository.save(foundUser);
        log.debug("updatedUser={}", updatedUser);

        return updatedUser;
    }
}
