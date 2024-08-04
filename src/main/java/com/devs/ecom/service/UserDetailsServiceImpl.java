package com.devs.ecom.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.devs.ecom.repository.UserRepository;
import com.devs.ecom.entity.User;
import com.devs.ecom.entity.UserPrincipal;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{

    @Autowired
	private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> userOptional = userRepository.findByEmail(username);


        User user = userOptional.orElseThrow(() -> {
            System.out.println("User 404");
            throw new UsernameNotFoundException("User 404");
        });

        return new UserPrincipal(user);

    }

}
