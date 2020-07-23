package com.codecool.newsbackend.service;

import com.codecool.newsbackend.entity.RegCredential;
import com.codecool.newsbackend.entity.UserData;
import com.codecool.newsbackend.repository.RegCredentialRepository;
import com.codecool.newsbackend.repository.UserDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    private RegCredentialRepository regCredentialRepository;

    public boolean handleLogin(String username, String password){

        return regCredentialRepository.existsByUsernameAndPassword(username, password);
    }

}
