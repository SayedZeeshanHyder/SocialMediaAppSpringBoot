package com.socialmedia.app.SocialMediaApp.Controller;

import com.socialmedia.app.SocialMediaApp.Jwt.JwtUtil;
import com.socialmedia.app.SocialMediaApp.Payload.LoginBody;
import com.socialmedia.app.SocialMediaApp.Payload.LoginResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("api/auth")
public class AuthController {

    private final JwtUtil jwtUtil;
    private final AuthenticationManager authenticationManager;
    private final UserDetailsService userDetailsService;

    public AuthController(JwtUtil jwtUtil, AuthenticationManager authenticationManager, UserDetailsService userDetailsService) {
        this.jwtUtil = jwtUtil;
        this.authenticationManager = authenticationManager;
        this.userDetailsService = userDetailsService;
    }

    @GetMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginBody loginBody) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginBody.getUsername(), loginBody.getPassword()));
        UserDetails userDetails = userDetailsService.loadUserByUsername(loginBody.getUsername());
        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setToken(jwtUtil.generateToken(loginBody.getUsername()));
        loginResponse.setCreatedAt(LocalDateTime.now());
        loginResponse.setExpiresAt(LocalDateTime.now().plusSeconds(60000));
        return ResponseEntity.ok(loginResponse);
    }

}
