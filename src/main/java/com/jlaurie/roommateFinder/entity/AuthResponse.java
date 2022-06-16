package com.jlaurie.roommateFinder.entity;

import com.jlaurie.roommateFinder.jwt.JwtTokenResponse;

public class AuthResponse {

    private Roommate roommate;

    private JwtTokenResponse jwtTokenResponse;


    public AuthResponse(Roommate roommate, JwtTokenResponse jwtTokenResponse) {
        this.roommate = roommate;
        this.jwtTokenResponse = jwtTokenResponse;
    }

    public Roommate getRoommate() {
        return roommate;
    }

    public JwtTokenResponse getJwtTokenResponse() {
        return jwtTokenResponse;
    }
}
