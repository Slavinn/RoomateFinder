package com.jlaurie.roommateFinder.jwt;

import com.jlaurie.roommateFinder.entity.AuthResponse;
import com.jlaurie.roommateFinder.entity.Roommate;
import com.jlaurie.roommateFinder.service.RoommateService;

import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

import java.sql.SQLException;
import java.util.List;
import java.util.Objects;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class JwtAuthenticationRestController {

    @Value("${jwt.http.request.header}")
    private String tokenHeader;

    @Autowired
    private RoommateService roommateService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;


    @Autowired
    private UserDetailsService jwtInMemoryUserDetailsService;
    
    

    @PostMapping("${jwt.get.token.uri}")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtTokenRequest authenticationRequest)
            throws AuthenticationException {

        authenticate(authenticationRequest.getEmail(), authenticationRequest.getPassword());

        final UserDetails userDetails = jwtInMemoryUserDetailsService.loadUserByUsername(authenticationRequest.getEmail());

        Roommate roommate = roommateService.findByEmail(authenticationRequest.getEmail());

        final String token = jwtTokenUtil.generateToken(userDetails);

        AuthResponse roommateResponse = new AuthResponse(roommate,  new JwtTokenResponse(token));

        return ResponseEntity.ok(roommateResponse);
    }

    @RequestMapping(value = "${jwt.refresh.token.uri}", method = RequestMethod.GET)
    public ResponseEntity<?> refreshAndGetAuthenticationToken(HttpServletRequest request) {
        String authToken = request.getHeader(tokenHeader);
        final String token = authToken.substring(7);
        String username = jwtTokenUtil.getUsernameFromToken(token);
        JwtUserDetails user = (JwtUserDetails) jwtInMemoryUserDetailsService.loadUserByUsername(username);

        if (jwtTokenUtil.canTokenBeRefreshed(token)) {
            String refreshedToken = jwtTokenUtil.refreshToken(token);
            return ResponseEntity.ok(new JwtTokenResponse(refreshedToken));
        } else {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @PostMapping("/signup")
    public String createRoommate(@RequestBody Roommate roommate) throws SQLException {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        roommate.setPassword(encoder.encode(roommate.getPassword()));
        roommateService.createRoommate(roommate);

        return "Created Roommate - " + roommate;
    }

    @GetMapping("/login/{email}")
    public Roommate getRoommateEmail(@PathVariable String email) {
        Roommate roommate = roommateService.findByEmail(email);

        if (roommate == null) {
            throw new RuntimeException("Roommate Email was not found - " + email);
        }

        return roommate;
    }


    @ExceptionHandler({AuthenticationException.class})
    public ResponseEntity<String> handleAuthenticationException(AuthenticationException e) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
    }

    private void authenticate(String email, String password) {
        Objects.requireNonNull(email);
        Objects.requireNonNull(password);

        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, password));
        } catch (DisabledException e) {
            throw new AuthenticationException("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new AuthenticationException("INVALID_CREDENTIALS", e);
        }
    }

}
