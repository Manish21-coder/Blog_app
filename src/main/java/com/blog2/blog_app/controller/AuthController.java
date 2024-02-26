package com.blog2.blog_app.controller;


import com.blog2.blog_app.entity.Role;
import com.blog2.blog_app.entity.User;
import com.blog2.blog_app.payload.LoginDto;

import com.blog2.blog_app.payload.SignUpDto;
import com.blog2.blog_app.repository.RoleRepository;
import com.blog2.blog_app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;


@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;  // this has data coming from db

    @Autowired
    private  PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;



    @PostMapping("/signin")
    public ResponseEntity<?> loginUser(@RequestBody LoginDto loginDto){
        //This has details of user and password comming form url of user or website.
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(loginDto.getUsernameOrEmail(),loginDto.getPassword());
        Authentication authenticate = authenticationManager.authenticate(usernamePasswordAuthenticationToken);
        //after its completed you create session variable

        SecurityContextHolder.getContext().setAuthentication(authenticate);


        return new ResponseEntity<>("User signed-in successfully",HttpStatus.OK);
    }



    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@RequestBody SignUpDto signUpDto){

           if(userRepository.existsByUsername(signUpDto.getUsername())){

               return  new ResponseEntity<>("Username is already taken!" , HttpStatus.BAD_REQUEST);
           }

        if(userRepository.existsByEmail(signUpDto.getEmail())){

            return  new ResponseEntity<>("Email is already taken!" , HttpStatus.BAD_REQUEST);
        }

        User user = new User();
          user.setName(signUpDto.getName());
          user.setUsername(signUpDto.getUsername());
          user.setEmail(signUpDto.getEmail());
          user.setPassword(passwordEncoder.encode(signUpDto.getPassword()));
        Role roles = roleRepository.findByName(signUpDto.getRoleType()).get();

      //  Set<Role> convertRolestoSet = new HashSet<>(); one way to do this
        //  convertRolestoSet.add(roles);

          user.setRoles(Collections.singleton(roles));  // this is the other way to do this.

        userRepository.save(user);


         return new ResponseEntity<>("User registered successfully" , HttpStatus.OK);
    }

}
