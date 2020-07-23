package com.codecool.newsbackend.controller;


import com.codecool.newsbackend.entity.LoginCredential;
import com.codecool.newsbackend.service.LoginService;
import com.codecool.newsbackend.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;


@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class LoginController {

    @Autowired
    LoginService loginService;

    @Autowired
    RegistrationService registrationService;


    @Autowired
    private JavaMailSender mailSender;

    void sendEmail() {

        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo("sibaluca@gmail.com");

        msg.setSubject("Testing from Spring Boot");
        msg.setText("Hello World \n Spring Boot Email");

        mailSender.send(msg);

    }

    @PostMapping(value = "/login", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Integer> doLogin( @RequestBody LoginCredential loginCredential) {
        boolean userExists = loginService.handleLogin(loginCredential.getUsername(), loginCredential.getPassword());
        System.out.println(loginCredential.getUsername() + " " + loginCredential.getPassword());
        if(userExists){
            sendEmail();
            return ResponseEntity.ok(loginService.getUserId(loginCredential.getUsername()));
        }

        return ResponseEntity.ok(-1);
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
