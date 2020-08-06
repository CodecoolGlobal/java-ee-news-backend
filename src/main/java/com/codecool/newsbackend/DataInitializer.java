package com.codecool.newsbackend;


import com.codecool.newsbackend.entity.RegCredential;
import com.codecool.newsbackend.entity.TopicSetting;
import com.codecool.newsbackend.entity.UserData;
import com.codecool.newsbackend.repository.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Collections;

@Component
@Slf4j
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private RegCredentialRepository regCredentialRepository;

    @Autowired
    private UserDataRepository userDataRepository;

    private final UserRepository users;

    @Autowired
    private TopicSettingRepository topicSetting;

    private final PasswordEncoder passwordEncoder;

    public DataInitializer(UserRepository users) {
        this.users = users;
        passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    @Override
    public void run(String... args) {
        log.debug("initializing sample data...");
        RegCredential regCredential = RegCredential.builder()
                .email("dinnye@dinnye.com")
                .password(passwordEncoder.encode("dinnye"))
                .username("dinnye")
                .build();



        TopicSetting newSettings1 = TopicSetting.builder()
                .business(false)
                .entertainment(false)
                .general(false)
                .health(false)
                .science(false)
                .sports(false)
                .technology(false)
                .build();

        UserData userData = UserData.builder()
                .username("dinnye")
                .password(passwordEncoder.encode("dinnye"))
                .regCredential(regCredential)
                .roles(Collections.singletonList("ROLE_USER"))
                .topicSetting(newSettings1)
                .build();

       users.saveAndFlush(userData);



        RegCredential regCredential2 = RegCredential.builder()
                .email("admin@admin.com")
                .password(passwordEncoder.encode("admin"))
                .username("admin")
                .build();


        TopicSetting newSettings2 = TopicSetting.builder()
                .business(false)
                .entertainment(false)
                .general(false)
                .health(false)
                .science(false)
                .sports(false)
                .technology(false)
                .build();


        UserData admin = UserData.builder()
                .username("admin")
                .password(passwordEncoder.encode("password"))
                .roles(Arrays.asList("ROLE_USER", "ROLE_ADMIN"))
                .topicSetting(newSettings2)
                .regCredential(regCredential2)
                .build();
        users.saveAndFlush(admin);
//

        //topicSetting.save(newSettings2);
//
//        admin.setTopicSetting(newSettings2);

        RegCredential regCredential3 = RegCredential.builder()
                .email("test@test.com")
                .password(passwordEncoder.encode("TestAcc19"))
                .username("Tester")
                .build();

        TopicSetting newSettings3 = TopicSetting.builder()
                .business(false)
                .entertainment(false)
                .general(false)
                .health(false)
                .science(false)
                .sports(false)
                .technology(false)
                .build();

        UserData tester = UserData.builder()
                .username("Tester")
                .password(passwordEncoder.encode("TestAcc19"))
                .regCredential(regCredential3)
                .roles(Collections.singletonList("ROLE_USER"))
                .topicSetting(newSettings3)
                .build();
        users.saveAndFlush(tester);
//

//        //topicSetting.save(newSettings3);
//
//        tester.setTopicSetting(newSettings3);






        log.debug("printing all users...");
        // users.findAll().forEach(v -> log.debug(" Newzappuser :" + v.toString()));
    }
}
