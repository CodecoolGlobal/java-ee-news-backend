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

    @Autowired
    private TopicSettingRepository topicSettingRepository;

    public boolean handleRegistration(String username, String email, String password) {
        boolean exists = regCredentialRepository.existsByUsernameOrEmail(username, email);
        if(exists){
            return true;
        }
        else {
            //password hashing needed

            RegCredential regCredential = RegCredential.builder()
                    .email(email)
                    .password(password)
                    .username(username)
                    .build();

            TopicSetting newSettings = TopicSetting.builder()
                    .business(false)
                    .entertainment(false)
                    .general(true)
                    .health(false)
                    .science(false)
                    .sports(false)
                    .technology(false)
                    .build();
            /*
            topicSettingRepository.save(newSettings);
            topicSettingRepository.flush();
            Long id = newSettings.getId();
            */

            UserData userData = UserData.builder()
                    .regCredential(regCredential)
                    .topicSetting(newSettings)
                    .build();
            userData.setRegCredential(regCredential);
            regCredentialRepository.save(regCredential);
            //topicSettingRepository.save(newSettings);
            userDataRepository.save(userData);

        }
        return false;
    }

    public int getUserId(String username){
        int userId = regCredentialRepository.getUserDataId(username);

        return userId;
    }
}
