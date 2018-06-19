package com.millky.demo.security.four;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service("userDetailsService")
public class UserDetailsServiceImp implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Transactional(readOnly = true)
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepository.findByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException("'" + username + "' User not found.");
        }

        UserBuilder builder;
        builder = org.springframework.security.core.userdetails.User.withUsername(username);
        builder.disabled(!user.isEnabled());
        builder.password(user.getPassword());
        builder.authorities(new SimpleGrantedAuthority(user.getRole().getAuthority()));

        UserDetails userDetails = builder.build();
        log.debug("UserDetails = {}", userDetails);
        return userDetails;
    }
}