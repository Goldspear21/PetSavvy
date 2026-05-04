package petsavvy.pet.services;

import petsavvy.pet.model.User;
import petsavvy.pet.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.ArrayList;
import java.util.List;

@Service("myUserDetailService")
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found: " + username));

        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_USER"));

        // ---> YOU NEED TO ADD THIS BLOCK <---
        // Make sure to match this string to the exact username you are logging in with!
        if ("Jason".equalsIgnoreCase(username)) {
            authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        }

        return org.springframework.security.core.userdetails.User
                .withUsername(user.getUsername())
                .password(user.getPassword())
                .authorities(authorities)
                .build();
    }
}
