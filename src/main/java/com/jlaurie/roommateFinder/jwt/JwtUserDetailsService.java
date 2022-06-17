package com.jlaurie.roommateFinder.jwt;

import com.jlaurie.roommateFinder.entity.Roommate;
import com.jlaurie.roommateFinder.service.RoommateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class JwtUserDetailsService implements UserDetailsService {

  @Autowired
  private RoommateService roommateService;

  @Override
  public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

    Roommate roommate = roommateService.findByEmail(email);
    if (roommate == null) {
      throw new UsernameNotFoundException("User not found with username: " + email);
    }
    return new org.springframework.security.core.userdetails.User(roommate.getEmail(), roommate.getPassword(),
            new ArrayList<>());
  }

}


