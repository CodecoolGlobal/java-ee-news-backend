package com.codecool.newsbackend.service;

import com.codecool.newsbackend.repository.TopicSettingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicSettingService {

    @Autowired
    private TopicSettingRepository topicSettingRepository;

    public void handleTopicSetting() {

    }
}
