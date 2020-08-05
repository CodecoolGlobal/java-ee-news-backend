package com.codecool.newsbackend.controller;

import com.codecool.newsbackend.entity.Article;
import com.codecool.newsbackend.entity.TopicSetting;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class FavouritesController {

    @RequestMapping(path = "/add-favourites", consumes = {MediaType.APPLICATION_JSON_VALUE}, method = POST)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public String saveTopicSettings(@RequestBody Article article) {
        System.out.println("mizu: " + article);
        return "setting saved";
    }
}
