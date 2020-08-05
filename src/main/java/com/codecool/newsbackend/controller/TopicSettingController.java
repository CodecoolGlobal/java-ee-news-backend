package com.codecool.newsbackend.controller;

import com.codecool.newsbackend.entity.TopicSetting;
import com.codecool.newsbackend.entity.UserData;
import com.codecool.newsbackend.service.TopicSettingService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class TopicSettingController {

    @Autowired
    TopicSettingService topicSettingService;

    @RequestMapping(path = "/savesettings/{username}", consumes = {MediaType.APPLICATION_JSON_VALUE}, method = POST)
    @ResponseBody
    //@ResponseStatus(HttpStatus.OK)
    public void saveTopicSettings(@RequestBody TopicSetting topicSetting, @PathVariable String username) {
        topicSettingService.updateUserTopicSettings(topicSetting, username);
        //return "setting saved";
    }

    @ResponseStatus(HttpStatus.OK)

    @RequestMapping(value = "/gettopicselection/{username}", method = GET)
    @ResponseBody
    public String getChosenTopics(@PathVariable String username, @RequestHeader String Authorization) throws IllegalAccessException {
        System.out.println("helloo" + Authorization);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        System.out.println(authentication.getPrincipal());
        //UserData user = (UserData) authentication.getPrincipal();
        return topicSettingService.buildUserChosenTopicSelection(username);
    }
}
