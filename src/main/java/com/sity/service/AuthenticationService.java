package com.sity.service;

import com.sity.model.request.AuthenticationRequest;
import com.sity.model.request.RegisterRequest;
import com.sity.model.response.AuthenticationResponse;
import com.sity.model.user.Role;
import com.sity.model.user.User;
import com.sity.model.user.UserRepository;
import com.sity.security.JwtUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtils jwtUtils;
    private final AuthenticationManager authenticationManager;
    public AuthenticationResponse register(RegisterRequest request){
        var user = User.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.USER)
                .build();
        repository.save(user);
        var jwtToken = jwtUtils.generateToken(user);

        return  AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

    public  AuthenticationResponse authenticate(AuthenticationRequest request){
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        var user = repository.findByEmail(request.getEmail())
                .orElseThrow();

        var jwtToken = jwtUtils.generateToken(user);
        return  AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }
}
