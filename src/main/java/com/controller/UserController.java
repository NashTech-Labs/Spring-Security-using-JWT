package com.controller;

import com.model.User;
import com.service.UserService;
import com.util.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

/**
 * The type User controller.
 */
@RestController

public class UserController {
    /**
     * The User service.
     */
    @Autowired
    UserService userService;
    /**
     * The Authentication manager.
     */
    @Autowired
    AuthenticationManager authenticationManager;
    /**
     * The Jwt utils.
     */
    @Autowired
    JwtUtils jwtUtils;

    /**
     * Create user user.
     *
     * @param user the user
     * @return the user
     */
    @PostMapping("/addUser")
    public User createUser(@RequestBody User user){
        return userService.saveUser(user);
    }


    /**
     * Welcome string.
     *
     * @return the string
     */
    @GetMapping("/")
    public String welcome(){
       return "WELCOME";
    }


    /**
     * Generate token string.
     *
     * @param user the user
     * @return the string
     * @throws Exception the exception
     */
    @PostMapping("/authenticate")
    public String generateToken(@RequestBody User user) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword())
            );
        } catch (Exception ex) {
            throw new Exception("inavalid username/password");
        }
        return jwtUtils.generateToken(user.getUsername());
    }
}
