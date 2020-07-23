package com.codecool.newsbackend.controller;

import com.codecool.newsbackend.entity.TopicSetting;
import com.codecool.newsbackend.service.TopicSettingService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class TopicSettingController {

    @Autowired
    TopicSettingService topicSettingService;

    @RequestMapping(path = "/savesettings/{user_id}", consumes = {MediaType.APPLICATION_JSON_VALUE}, method = POST)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public String saveTopicSettings(@RequestBody TopicSetting topicSetting, @PathVariable Long user_id) {
        topicSettingService.updateUserTopicSettings(topicSetting, user_id);
        return "setting saved";
    }

    @RequestMapping(value = "/gettopicselection/{user_id}", method = GET)
    @ResponseBody
    public String getChosenTopics(@PathVariable Long user_id) throws IllegalAccessException {

        return topicSettingService.buildUserChosenTopicSelection(user_id);
    }
}
