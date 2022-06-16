package com.jlaurie.roommateFinder.jwt;

import com.jlaurie.roommateFinder.entity.Roommate;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;

public class JwtTokenResponse implements Serializable {

    private static final long serialVersionUID = 8317676219297719109L;

    private final String token;

    public JwtTokenResponse(String token) {
        this.token = token;
    }

    public String getToken() {
        return this.token;
    }
}
