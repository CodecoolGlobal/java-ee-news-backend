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

    @Autowired
    private UserDataRepository userDataRepository;


    public boolean handleLogin(String username, String password){
        //hash password
        boolean exists = regCredentialRepository.existsByUsernameAndPassword(username, password);
        if(exists){
            return true;
        }

        //create session

//        else {
//
//            RegCredential regCredential = RegCredential.builder()
//
//                    .password(password)
//                    .username(username)
//                    .build();
//
//            UserData userData = UserData.builder()
//                    .regCredential(regCredential)
//                    .build();
//            userData.setRegCredential(regCredential);
//            regCredentialRepository.save(regCredential);
//            userDataRepository.save(userData);
//
//        }
        return false;
    }

    public int getUserId(String username){
        int userId = regCredentialRepository.getByUserId(username);
        return userId;
    }
}
