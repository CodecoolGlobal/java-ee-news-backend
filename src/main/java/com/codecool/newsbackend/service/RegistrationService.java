package com.codecool.newsbackend.service;

import com.codecool.newsbackend.repository.RegCredentialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {

    @Autowired
    private RegCredentialRepository regCredentialRepository;

    public void handleRegistration() {
        // create regCred obj from JSON
        // create UserData obj
        // pass to repository??
        // pass response to controller if ok or not
    }
}
