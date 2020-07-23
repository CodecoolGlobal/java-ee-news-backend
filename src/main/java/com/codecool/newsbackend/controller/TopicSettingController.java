package com.codecool.newsbackend.controller;

import com.codecool.newsbackend.entity.TopicSetting;
import com.codecool.newsbackend.service.TopicSettingService;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class TopicSettingController {

    @Autowired
    TopicSettingService topicSettingService;

    @PostMapping(path = "/savesettings", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public String saveTopicSettings(@RequestBody TopicSetting topicSetting) throws IllegalAccessException {

        topicSettingService.updateUserTopicSettings(topicSetting);


        return "updated";
    }

    @RequestMapping(value = "/gettopicselection/{user_id}", method = GET)
    @ResponseBody
    public String getChosenTopics(@PathVariable Long user_id) throws IllegalAccessException {
        String topicSelection = topicSettingService.buildUserChosenTopicSelection(user_id);

        return topicSelection;
    }
}
