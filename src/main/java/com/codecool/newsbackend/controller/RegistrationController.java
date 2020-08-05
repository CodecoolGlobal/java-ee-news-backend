package com.codecool.newsbackend.controller;


import com.codecool.newsbackend.entity.RegCredential;
import com.codecool.newsbackend.security.JwtTokenServices;
import com.codecool.newsbackend.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class RegistrationController {


    @Autowired
    RegistrationService registrationService;

    @ResponseStatus(HttpStatus.OK)
    @PostMapping(value = "/registration", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Integer> doRegistration( @RequestBody RegCredential regCredential) {
        boolean userExists = registrationService.handleRegistration(regCredential.getUsername(), regCredential.getEmail(), regCredential.getPassword());
        if(userExists){
            return ResponseEntity.ok(-1);
        }
        int userId = registrationService.getUserId(regCredential.getUsername());
        return ResponseEntity.ok(userId);
    }


    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }
}
