package com.codecool.newsbackend.service;

import com.codecool.newsbackend.entity.RegCredential;
import com.codecool.newsbackend.entity.TopicSetting;
import com.codecool.newsbackend.entity.UserData;
import com.codecool.newsbackend.repository.RegCredentialRepository;
import com.codecool.newsbackend.repository.TopicSettingRepository;
import com.codecool.newsbackend.repository.UserDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {

    @Autowired
    private RegCredentialRepository regCredentialRepository;

    @Autowired
    private UserDataRepository userDataRepository;


    public boolean handleRegistration(String username, String email, String password) {

        boolean exists = regCredentialRepository.existsByUsernameOrEmail(username, email);
        if(exists){
            return true;
        }
        else {
            RegCredential regCredential = RegCredential.builder()
                    .email(email)
                    .password(password)
                    .username(username)
                    .build();

            TopicSetting newSettings = TopicSetting.builder()
                    .business(false)
                    .entertainment(false)
                    .general(false)
                    .health(false)
                    .science(false)
                    .sports(false)
                    .technology(false)
                    .build();

            UserData userData = UserData.builder()
                    .regCredential(regCredential)
                    .topicSetting(newSettings)
                    .build();
            userData.setRegCredential(regCredential);
            regCredentialRepository.save(regCredential);
            userDataRepository.save(userData);

        }
        return false;
    }

    public int getUserId(String username){

        return regCredentialRepository.getUserDataId(username);
    }
}
