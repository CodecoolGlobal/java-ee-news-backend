package com.codecool.newsbackend.controller;

import com.codecool.newsbackend.entity.TopicSetting;
import com.codecool.newsbackend.entity.UserData;
import com.codecool.newsbackend.service.TopicSettingService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import java.util.Arrays;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@CrossOrigin(origins = "http://localhost:3000")

public class TopicSettingController {

    @Autowired
    TopicSettingService topicSettingService;

    private String getCookieValue(HttpServletRequest req, String cookieName) {
        return Arrays.stream(req.getCookies())
                .filter(c -> c.getName().equals(cookieName))
                .findFirst()
                .map(Cookie::getValue)
                .orElse(null);
    }

    @RequestMapping(path = "/savesettings/{username}", consumes = {MediaType.APPLICATION_JSON_VALUE}, method = POST)
    @ResponseBody
    public void saveTopicSettings(@RequestBody TopicSetting topicSetting, @PathVariable String username) {
        topicSettingService.updateUserTopicSettings(topicSetting, username);
    }

    @ResponseStatus(HttpStatus.OK)

    @RequestMapping(value = "/gettopicselection/{username}", method = GET)
    @ResponseBody
    public String getChosenTopics(@PathVariable String username, @RequestHeader String Authorization,HttpServletRequest request) throws IllegalAccessException {
        String cookiesss = request.getHeader("Set-Cookie");
        System.out.println("helloo" + Authorization);
        System.out.println("cookie: "+ cookiesss);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        System.out.println(authentication.getPrincipal());
        return topicSettingService.buildUserChosenTopicSelection(username);
    }
}
