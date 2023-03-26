package com.example.demo.securityconf;

import com.example.demo.entity.UserWithPass;
import com.example.demo.repository.UserWithPassRepo.IUserWithPassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserWithPassUserDetailsService implements UserDetailsService {

    @Autowired
    IUserWithPassRepository userWithPassRepository;



    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserWithPass> login = userWithPassRepository.findByLogin(username);

        return login.map(UserWithPassUserDetails::new)
                .orElseThrow(() -> new UsernameNotFoundException("user not found" + username));
    }
}
