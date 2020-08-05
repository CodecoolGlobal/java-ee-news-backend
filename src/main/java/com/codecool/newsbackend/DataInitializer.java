package com.codecool.newsbackend;


import com.codecool.newsbackend.entity.TopicSetting;
import com.codecool.newsbackend.entity.UserData;
import com.codecool.newsbackend.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Collections;

@Component
@Slf4j
public class DataInitializer implements CommandLineRunner {


    private final UserRepository users;

    private final PasswordEncoder passwordEncoder;

    public DataInitializer(UserRepository users) {
        this.users = users;
        passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    @Override
    public void run(String... args) {
        log.debug("initializing sample data...");

        TopicSetting newSettings = TopicSetting.builder()
                .business(false)
                .entertainment(false)
                .general(false)
                .health(false)
                .science(false)
                .sports(false)
                .technology(false)
                .build();

        users.save(UserData.builder()
                .username("user")
                .password(passwordEncoder.encode("password"))
                .topicSetting(newSettings)
                .roles(Arrays.asList("ROLE_USER"))
                .build()
        );

        TopicSetting newSettings2 = TopicSetting.builder()
                .business(false)
                .entertainment(false)
                .general(false)
                .health(false)
                .science(false)
                .sports(false)
                .technology(false)
                .build();

        users.save(UserData.builder()
                .username("admin")
                .password(passwordEncoder.encode("password"))
                .topicSetting(newSettings2)
                .roles(Arrays.asList("ROLE_USER", "ROLE_ADMIN"))
                .build()
        );

        TopicSetting newSettings3 = TopicSetting.builder()
                .business(false)
                .entertainment(false)
                .general(false)
                .health(false)
                .science(false)
                .sports(false)
                .technology(false)
                .build();

        users.save(UserData.builder()
                .username("Tester")
                .password(passwordEncoder.encode("test"))
                .topicSetting(newSettings3)
                .roles(Collections.singletonList("ROLE_USER"))
                .build()
        );
        log.debug("printing all users...");
        users.findAll().forEach(v -> log.debug(" Newzappuser :" + v.toString()));
    }
}
